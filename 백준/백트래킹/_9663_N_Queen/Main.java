package 백준.백트래킹._9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(dfs(0, new boolean[N][N]));
    }

    private static int dfs(int cnt, boolean[][] visited){
        int result = 0;
        if(cnt == N){

            return 1;
        }

        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(visited[y][x]) continue;
                // 깊은 복사 복사
                boolean[][] newVisited = deepCopy(visited);
                // 퀸의 경로로 visited 해준다.
                makeVisitedTrue(y, x, newVisited);
                result += dfs(cnt + 1, newVisited);
            }
        }

        return result;
    }

    private static void makeVisitedTrue(int y,int x, boolean[][] visited){
        int[] dy = {1 ,-1, -1, 1};
        int[] dx = {1 ,1, -1, -1};
        // 상하좌우
        for(int i = 0; i < N; i++){
            visited[y][i] = true;
            visited[i][x] = true;
        }
        // 대각선
        for(int i = 0; i < 4; i++){
            int ny = y;
            int nx = x;
            while(true){
                ny += dy[i];
                nx += dx[i];
                if(ny < 0 || nx < 0 || N <= ny || N <= nx) break;
                visited[ny][nx] = true;
            }
        }
    }

    private static boolean[][] deepCopy(boolean[][] arr){
        boolean[][] newArr = new boolean[N][N];

        for(int y = 0; y < N; y++){
            System.arraycopy(arr[y], 0, newArr[y], 0, N);
        }

        return newArr;
    }
}
