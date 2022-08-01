package 백준.DP._15724_주지수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

- memo를 먼저 다 구함
  - 인덱스를 1부터 시작하게 설계.
  - memo[i][j] = memo[i-1][j] + memo[i][j - 1] - memo[i - 1][j - 1] + arr[i][j]
  - 중복되는 곳 제거 필수

- 전체 합 구하는법
    - memo[x2][y2] - memo[x1 -1][y2] - memo[x2][y1 - 1] + memo[x1 - 1][y1 - 1]
    - 중복되는 곳 제거 필수
- string tokener가 시간이 확 줄긴 하는듯
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);
        int[][] arr = new int[N + 1][M + 1];
        int[][] memo = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            String[] value = br.readLine().split(" ");
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(value[j - 1]);
            }
        }

        // 전체 memo 구하기
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                memo[i][j] = memo[i-1][j] + memo[i][j - 1] - memo[i - 1][j - 1] + arr[i][j];
            }
        }


        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            int[] space = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = space[0], y1 = space[1], x2 = space[2], y2 = space[3];
            sb.append(memo[x2][y2] - memo[x1 -1][y2] - memo[x2][y1 - 1] + memo[x1 - 1][y1 - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
