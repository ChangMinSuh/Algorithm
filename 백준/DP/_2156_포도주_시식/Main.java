package 백준.DP._2156_포도주_시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
dp, 재귀

- 역으로 마실 수 없는 잔을 고른다.
    - 역으로 안하면, 연속으로 고른 잔도 체크해야 될 것 같다. 복잡할 것 같다.
    - 붙여서 띄는 경우, 한 칸 , 두 칸을 모두 고려.
        - 100 100 1 1 100 100
        - 100 1 100 1 100 1
        - 100 100 1 100 100 1

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputArr = new int[N + 1];
        int[] memo = new int[N + 1];
        int sum = 0;

        Arrays.fill(memo, -1);

        for(int i = 0; i < N; i++){
            int inputN = Integer.parseInt(br.readLine());
            inputArr[i] = inputN;
            sum += inputArr[i];
        }
        memo[0] = inputArr[0]; // if문 줄임.
        inputArr[N] = 0; // 초기화

        int result = sum - dp(N,inputArr,memo);
        System.out.println(result);
    }
    private static int dp(int N, int[] inputArr, int[] memo){
        if(N < 0) return 0;

        if(memo[N] > -1) return memo[N];

        memo[N] = Math.min(Math.min(
                dp(N - 1, inputArr, memo),
                dp(N - 2, inputArr, memo)),
                dp(N - 3, inputArr, memo)) + inputArr[N];

        return memo[N];
    }
}

