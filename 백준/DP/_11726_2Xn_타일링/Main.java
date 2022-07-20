package 백준.DP._11726_2Xn_타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
dp, 재귀

- 타일 1개는 1, 타일 2개는 2로 치환하여 덧셈식으로 바꿈
   - 1 + 1 + 1 + 1
   - 1 + 2 + 1
   - 2 + 2
- topdown으로 그 전의 값들을 기억하며 완전탐색.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);
        dp(N, memo);
        System.out.println(memo[N]);
    }

    private static int dp(int N, int[] memo){
        if(N < 0) return 0;
        if(N == 0) return 1;

        if(memo[N] > -1) return memo[N];

        memo[N] = (dp(N - 1, memo) + dp(N - 2, memo)) % 10007;
        return memo[N];
    }
}
