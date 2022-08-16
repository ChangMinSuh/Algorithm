package 백준.구현._21608_상어_초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
구현, map

1. linkedHashMap을 이용해 자신을 key, 좋아하는 학생을 배열로 value에 넣는다.
  - 순서대로 삽입하기 위해.
2.  좋아하는 학생이 교실 내에 있는지 linkedHashMap을 for문으로 하나하나 검사하여, 조건에 맞는 자리에 앉게한다.
  - 좋아하는 학생이 교실에 없는 경우
    1. 현재 자리에 누가 앉았다면 continue.
    2. 모든 자리를 탐색하여 주의에 비어있는 칸이 가장 많은 자리를 선택하여 앉는다.
  - 좋아하는 학생이 교실에 있는 경우
    1. 현재 자리에 누가 앉았다면 continue.
    2. 주의에 친구 수가 많은경우,혹은 같다면 주의에 빈공간이 많은 경우에 배치한다.
3. 모든 학생이 자리가 생긴다면, linkedHashMap을 통해 점수를 계산한다.
  - for문을 통해 주의에 좋아하는 친구 하나하나를 검사한다.


 */

public class Main {
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, int[]> map = new LinkedHashMap<>();
        int[][] board = new int[N][N];
        // linkedHashMap 삽입
        // 자신을 key, 좋아하는 학생을 배열로 value
        for(int i = 0; i < N * N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int[] value = new int[4];
            for(int j = 0; j < 4; j++){
                value[j] = Integer.parseInt(st.nextToken());
            }
            map.put(key, value);
        }

        for(int key: map.keySet()) {
            // 좋아하는 학생이 교실에 있는지 저장.
            List<RC> list = new ArrayList<>();
            // 좋아하는 학생 탐색
            int[] values = map.get(key);
            for (int j = 0; j < 4; j++) {
                {
                    RC rc = getStudentInBoard(values[j], board, N);
                    if (rc == null) continue;
                    list.add(rc);
                }
            }

            // 좋아하는 학생이 교실에 없는경우
            if (list.isEmpty()) {
                int max = -1;
                RC newRc = new RC(0, 0);

                // 모든 경우 중 비어있는 칸이 가장 많은 경우 선택
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {;
                        if(board[r][c] > 0) continue;
                        int cnt = countAdjacentNull(r, c, board, N);
                        if (max < cnt) {
                            newRc = new RC(r, c);
                            max = cnt;
                        }
                    }
                }

                board[newRc.r][newRc.c] = key;
                continue;
            }
            // 좋아하는 학생이 교실에 있는경우
            // 주의에 친구들이 많은경우, 같다면 주의에 빈공간이 많은 경우에 배치한다.
            int friendMax = -1;
            int nullMax = -1;
            RC newRc = new RC(0, 0);


            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    // 값이 있다면 넘기기
                    if(board[r][c] > 0) continue;
                    int friendCnt = 0;
                    int nullCnt = 0;
                    // 주변 상황 확인
                    for (int j = 0; j < 4; j++) {
                        int newR = r + dr[j];
                        int newC = c + dc[j];
                        if (newR < 0 || newC < 0 || newR >= N || newC >= N) continue;
                        // 주변에 친구가 얼마나 있는지 확인
                        for (int k = 0; k < 4; k++) {
                            if (values[k] == board[newR][newC]) {
                                friendCnt++; // 있다면 cnt + 1
                            }
                        }
                        // 주변에 빈 공간이 얼마나 있는지 확인
                        nullCnt = countAdjacentNull(r, c, board, N);
                    }
                    // 좋아하는 친구가 많이 있거나,
                    // 같다면 빈곳이 많은 자리를 채택.
                    if (
                        friendMax < friendCnt ||
                        friendMax == friendCnt && nullMax < nullCnt
                    ) {
                        friendMax = friendCnt;
                        nullMax = nullCnt;
                        newRc = new RC(r, c);
                    }
                }
            }


            board[newRc.r][newRc.c] = key;
        }
        int result = 0;
        // 점수 구하기
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                int cnt = 0;
                for(int j = 0; j < 4; j++ ){
                    int newR = r + dr[j];
                    int newC = c + dc[j];

                    if(newR < 0 || newC < 0 || newR >= N || newC >= N) continue;

                    // 인접한 자리에 좋아하는 사람이 있는지 확인.
                    int[] values = map.get(board[r][c]);
                    for(int k = 0; k < 4; k++){
                        if(values[k] == board[newR][newC]) cnt++; // 있다면 cnt + 1
                    }
                }
                result += Math.pow(10, cnt) / 10;
            }
        }
        System.out.println(result);
    }

    // board에서 학생을 찾음.
    static RC getStudentInBoard(int num, int[][] board, int N){
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(board[r][c] == num) return new RC(r,c);
            }
        }
        return null;
    }

    // 주변의 빈칸의 개수를 구해줌.
    static int countAdjacentNull(int r, int c, int[][] board, int N){
        int cnt = 0;
        for(int j = 0; j < 4; j++){
            int newR = r + dr[j];
            int newC = c + dc[j];

            if(newR < 0 || newC < 0 || newR >= N || newC >= N
                    || board[newR][newC] > 0) continue;

            cnt++;
        }
        return cnt;
    }

    static class RC{

        int r;
        int c;
        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
