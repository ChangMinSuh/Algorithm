package 백준.DP._2293_동전_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
2차원dp

동전을 큰 순서로 정렬 후, 차레대로 탐색 시작
동전은 자신보다 작은 동전을 탐색할 수 없다.
각 동전별로 memo 제작.

ex)
3,2,1
1. 3
2. 3, 2
3. 3, 2, 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lineArr = br.readLine().split(" ");
        int N = Integer.parseInt(lineArr[0]);
        int K = Integer.parseInt(lineArr[1]);
        Integer[] coins = new Integer[N];
        int[][] memo = new int[N][10005];
        for(int i =0; i < N; i++){
            Arrays.fill(memo[i], -1);
        }

        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        // 큰수가 앞으로 나오도록 정렬
        Arrays.sort(coins, ((o1, o2) -> o2 - o1));


        int result = dp(0, N ,K, coins, memo);
        System.out.println(result);
    }

    static private int dp(int sum, int nowCoinIndex, int K, Integer[] coins, int[][] memo){
        if(K < sum) return 0;
        if(K == sum) return 1;


        int result = 0;
        // nowCoinIndex로 자신보다 작은 숫자는 나올 수 없도록 한다.
        for(int i = 0; i < nowCoinIndex; i++){
            if(memo[i][sum] == -1) { // memo에 없다면 재귀로 들어감.
                memo[i][sum] = 0;
                memo[i][sum] += dp(sum + coins[i], i + 1, K, coins, memo);
            }
            result += memo[i][sum];
        }
        return result;
    }
}
