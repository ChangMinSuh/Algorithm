package 백준.그래프탐색._2206_벽_부수고_이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
bfs

- 처음에 dfs로 접근했지만, 시간초과. dp를 사용해야 할 것 같다.

- 두번쨰에 bfs 사용
    - 3차원 배열 만들어 이동 경로 bfs에 따라 증가시키며 저장
    - 벽은 1 => -1로 저장
    - arr[0][][]에는 하나도 벽을 뚫지 못했을 경우 저장
    - arr[1][][]에는 하나의 벽을 뚫었을 때 저장.
    - bfs로 한칸한칸 늘어나기 때문에 시간이 오바되어 겹치는 일은 없을 것 같다.
 */


public class Main {
    static int[] ny = {1, 0, -1, 0};
    static int[] nx = {0, -1, 0, 1};
    static int[][][] arr;
    static boolean[][] visited;
    static int N;
    static int M;
    static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if(N == 0 && M == 0) {
            System.out.println(1); return;
        }
        arr = new int[2][N][M];
        visited = new boolean[N][M];
        for(int y = 0; y < N; y++){
            String line = br.readLine();
            for(int x = 0; x < M; x++){
               arr[1][y][x] = arr[0][y][x] = line.charAt(x) == '1' ? -1 : 0;
            }
        }

        // bfs
        Queue<BrokenYX> qu = new LinkedList<>();

        qu.add(new BrokenYX(0,0,0));

        while(!qu.isEmpty()){
            BrokenYX quPoll = qu.poll();
            int broken = quPoll.broken;
            int y = quPoll.Y;
            int x = quPoll.X;

            for(int i = 0; i < 4; i++){
                int newY = ny[i] + y;
                int newX = nx[i] + x;

                if(newY < 0 || newX < 0 || N <=newY || M <= newX // 장외
                || arr[broken][newY][newX] > 0 // 이미 이동했으면
                ) continue;

                // 비어있는 자리라면 (벽 X)
                if(arr[broken][newY][newX] == 0){
                    arr[broken][newY][newX] = arr[broken][y][x] + 1;
                    qu.add(new BrokenYX(broken, newY, newX));
                    continue;
                }

                // 벽이 있고 부신적이 없다면
                if(arr[broken][newY][newX] == -1 && broken == 0){
                    arr[1][newY][newX] = arr[broken][y][x] + 1;
                    qu.add(new BrokenYX(1, newY, newX));
                }
            }
        }
        if(arr[0][N - 1][M - 1] == 0) arr[0][N - 1][M - 1] = Integer.MAX_VALUE;
        if(arr[1][N - 1][M - 1] == 0) arr[1][N - 1][M - 1] = Integer.MAX_VALUE;
        int result = Math.min(arr[0][N - 1][M - 1], arr[1][N - 1][M - 1]);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result + 1);
    }
    static class BrokenYX{
        int broken;
        int Y;
        int X;
        public BrokenYX(int broken, int y, int x) {
            this.broken = broken;
            Y = y;
            X = x;
        }
    }
}


