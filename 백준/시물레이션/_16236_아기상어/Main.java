package 백준.시물레이션._16236_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
bfs, 시물레이션


- 자신보다 작은 상어를 bfs를 통해 찾는다.
    - 해당하는 조건이 나오면, 거리만큼 정답에 더해주고, 엄마의 도움이 필요할 때 까지 반복.

- 가장위에 있고, 왼쪽에 있는 물고기를 찾아야 함.
    - ArrayList를 통해 우선 받고, sort 후 queue에 다시 푸쉬

- 구현이 아주 빡세다.
 */

public class Main {
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int time = 0; // 정답
        int sharkSize = 2;
        int sharkEats = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        YX startYX = null; // 상어 위치
        for(int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
                if(arr[y][x] == 9) { startYX = new YX(y, x); arr[y][x] = 0; }
            }
        }

        // 엄마의 도움이 필요할 떄 까지 반복복
       while(true){
           // bfs
           Queue<YX> qu = new LinkedList<>();
           qu.add(startYX);
           boolean isAte = false;
           int distance = 0;
           boolean[][] isVisited = new boolean[N][N];
           isVisited[startYX.y][startYX.x] = true;
           // 현재 상어 위치에서 가까운 상어 찾기
            while(!qu.isEmpty()){
                ArrayList<YX> list = new ArrayList<>();
                int quSize = qu.size();
                // 같은 거리에서 조건에 맞는 상어 먹이 찾기
                // qu에 qu.size 만큼 들어있는 장소들은 다 같은 거리다.
                for(int quIdx = 0; quIdx < quSize; quIdx++){
                    YX nowYX = qu.poll();
                    // 먹을 수 있는 상어를 찾았다면!
                    // 이쪽에서 찾아주는 것이 관건이였다.
                    if(arr[nowYX.y][nowYX.x] != 0 && arr[nowYX.y][nowYX.x] < sharkSize){
                        startYX = new YX(nowYX.y, nowYX.x); // 시작위치 변경
                        time += distance; // 정답 업데이트
                        isAte = true; // while문 탈출
                        // 상어 먹이와 크기 변경
                        sharkEats++;
                        if(sharkSize <= sharkEats){
                            sharkEats = 0;
                            sharkSize++;
                        }
                        arr[nowYX.y][nowYX.x] = 0; // 해당부분 이제 아무 물고기도 없으니 초기화
                        break;
                    }
                    for(int i = 0; i < 4; i++){
                        int ny = nowYX.y + dy[i];
                        int nx = nowYX.x + dx[i];
                        if(ny < 0 || nx < 0 || N <= ny || N <= nx // 장외 라면
                                || isVisited[ny][nx]  // 방문한적 있다면
                                || arr[ny][nx] > sharkSize) // 나보다 더 크다면
                            continue;
                        isVisited[ny][nx] = true;
                        list.add(new YX(ny, nx));
                    }
                }
                if(isAte) break;
                // list에 쌓아놓은 것 Queue에 넣기
                // y 올림차순. 같다면 x 오름차순
                list.sort((o1, o2) -> o1.y == o2.y ?
                        o1.x - o2.x :
                        o1.y - o2.y
                );

                qu.addAll(list);
                distance++;
            }
            if(isAte) continue;
            System.out.println(time);
            return;
        }
    }

    static class YX {
        int y;
        int x;

        public YX(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
