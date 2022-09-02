package 백준.시물레이션._16234_인구_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
bfs

- for문을 통해 모든 값을 하나하나 bfs 돌림
    - queue 대신 ArrayList 사용
        - 최종 list에 들어있는 값은 국경선을 공유하는 나라들.
        - 대신 cnt 변수 사용하여 검사.
    - 인접한 나라의 인구수 차가 L과 R 사이 값이라면 list에 삽입
    - list의 값을 평균내어 각 배열에 삽입한다.
    - 최종 변경이 없을 때 까지 while문
        - 모든 나라에서 list가 1이라면 최종 변경이 없는 것!
        - (while문 실행 한 개수 - 최종변경 유무) 가 정답.
 */

public class Main {
    static int[] dy = {0, -1 ,0 ,1};
    static int[] dx = {1, 0, -1 ,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int day = 0;
        for (int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isFinished;
        do{ isFinished = true;
            boolean[][] isVisited = new boolean[N][N];
            for (int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    if(isVisited[y][x]) continue;

                    // 큐 대신 사용. 여기 모여있는 나라들이 국경선 공유하는 나라들
                    List<YX> list = new ArrayList<>();
                    int cnt = 0;
                    list.add(new YX(y,x));
                    isVisited[y][x] = true;
                    int value = arr[y][x]; // 넣을 평균 값
                    while(cnt < list.size()){
                        // poll 대신 cnt로 측정.
                        YX quPull = list.get(cnt++);

                        for(int i = 0; i < 4; i++){
                            int ny = quPull.y + dy[i];
                            int nx = quPull.x + dx[i];
                            if(0 > ny || 0 > nx || ny >= N || nx >= N // 장외일 때
                            || isVisited[ny][nx]
                            || L > Math.abs(arr[ny][nx] - arr[quPull.y][quPull.x]) // L보다 작을 때
                            || R < Math.abs(arr[ny][nx] - arr[quPull.y][quPull.x])) // R보다 클 떄
                                continue;
                            // 국경선을 공유한다면
                            isVisited[ny][nx] = true;
                            list.add(new YX(ny,nx));
                            value += arr[ny][nx];
                        }
                    }
                    if(list.size() == 1)
                        continue;

                    isFinished = false;
                    value /= list.size();

                    for(YX yx: list){
                        arr[yx.y][yx.x] = value;
                    }
                }
            }
            if(!isFinished) day++;
        } while(!isFinished);

        System.out.println(day);
    }

    private static class YX {
        int y;
        int x;

        public YX(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
