package 백준.그래프탐색._1600_말이_되고픈_원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
bfs

- 원숭이로 걷는 경우와 말로 걷는 경우를 구분하여 저장한다.
- arr 3차원 배열 생성
    - 말을 0번 사용, 1번사용 ... k번 사용을 bfs를 통해 arr에 저장
    - ex arr[3]: 말을 3번 탔을 떄의 bfs 배열
    - bfs를 이용해 시작점에서 도달 할 수 있는 모든 최소 거리를 저장.
- 모든 arr 끝점 중 가장 작은 값 -1이 정답. 모두가 0이면 -1 출력
    - bfs한 첫 배열(arr[0][0][0]) 1로 시작하기 떄문에 결과 값은 result -1 해줘야함.

 */
public class Main {
    static int[] my = {1, 0, -1, 0};
    static int[] mx = {0, -1, 0, 1};
    static int[] hy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int [][][] arr;
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        Queue<KYX> qu = new LinkedList<>();
        arr = new int[K + 1][H][W]; // 말 이동이 몇번 사용했는지에 따라 다르게 저장.
        // 3차원 배열 모두 저장.
        for(int y = 0; y < H; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < W; x++){
                // 장애물을 -1로 지정.
                int input = Integer.parseInt(st.nextToken()) == 1 ? -1 : 0;
                for(int k = 0; k <= K; k++){
                    arr[k][y][x] = input;
                }
            }
        }

        qu.add(new KYX(0,0,0));
        arr[0][0][0] = 1;

        while(!qu.isEmpty()){
            KYX pollKYX = qu.poll();
            int k = pollKYX.k;
            int x = pollKYX.x;
            int y = pollKYX.y;

            // 원숭이 무빙
            for(int i = 0; i < 4; i++){
                int newY = y + my[i];
                int newX = x + mx[i];

                if(newY < 0 || newX < 0 || H <= newY || W <= newX // 장외 라면
                || arr[k][newY][newX] != 0)  // 이미 갔거나 갈 수 없는 곳이라면면
                   continue;

                arr[k][newY][newX] = arr[k][y][x] + 1;
                qu.add(new KYX(k,newY,newX));
            }

            if(k >= K) continue; // 말 최대치만큼 갔다면 넘김.

            // 말 무빙
            for(int i = 0; i < 8; i++){
                int newY = y + hy[i];
                int newX = x + hx[i];
                int newK = k + 1;

                if(newY < 0 || newX < 0 || H <= newY || W <= newX // 장외 라면
                        || arr[newK][newY][newX] != 0)  // 이미 갔거나 갈 수 없는 곳이라면면
                    continue;

                arr[newK][newY][newX] = arr[k][y][x] + 1;
                qu.add(new KYX(newK, newY, newX));
            }
        }

        int result = Integer.MAX_VALUE;

        for(int k = 0; k <= K; k++){
            if(arr[k][H - 1][W - 1] == 0) continue;
            result = Math.min(result, arr[k][H - 1][W - 1]);
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result - 1);
    }

    static class KYX{
        int k;
        int y;
        int x;

        public KYX(int k, int y, int x) {
            this.k = k;
            this.y = y;
            this.x = x;
        }
    }
}
