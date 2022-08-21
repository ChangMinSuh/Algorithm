package 백준.그래프탐색._7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
bfs

- 2차원 배열 arr에 정보 저장.
    - 1 이면 토마토 익음. visited 대체 가능.
- 날짜를 구해야 하니 n차별 개수만큼 큐를 실행.
    - 1일
        - arr[y][x] 값이 1인 토마토 만큼 큐에 삽입
        - 당시 큐에 들어있는 만큼만 for문을 사용해 인접한 안 익은 토마토(0) 큐에 삽입.(이때 1로 바꿔줌)
    - n일
        - 당시 큐에 들어있는 만큼만 for문을 사용해 인접한 안 익은 토마토(0) 큐에 삽입.(이때 1로 바꿔줌)
    - 큐가 비워질때 까지 반복
- 위 작업을 마친 후
    - 안익은 토마토(0)가 있다면 -1
    - 그 외에는 날짜만큼.
 */
public class Main {
    static int[] ny = {0, -1, 0, 1};
    static int[] nx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M]; // 1이면 토마토 익음(visited 대체 가능).
        Queue<YX> qu = new LinkedList<>();

        // arr init
        for(int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
                if(arr[y][x] > 0) { // 토마토가 들어있다면
                    qu.add(new YX(y, x));
                }
            }
        }

        int result = -1;

        while(!qu.isEmpty()){
            result++;
            int quSize = qu.size(); // 날짜를 기록하기 위해 당시 사이즈만큼 for문 돌림. 그 후에는 날짜++
            for(int c = 0; c < quSize; c++){
                YX pollYX = qu.poll();
                for(int i = 0; i < 4; i++){
                    int newY = ny[i] + pollYX.y;
                    int newX = nx[i] + pollYX.x;

                    if(newY < 0 || newX < 0 || N <= newY || M <= newX // 장외라면
                            || arr[newY][newX] == 1     // 토마토가 이미 익었다면
                            || arr[newY][newX] == -1)   // 토마토가 없는 곳이라면
                        continue;

                    arr[newY][newX] = 1;
                    qu.add(new YX(newY, newX));
                }
            }
        }

        // 토마토 검사
        for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                if(arr[y][x] != 0) continue;

                System.out.println(-1);
                return;
            }
        }
        System.out.println(result);
    }

    static class YX{
        int y;
        int x;
        public YX(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
