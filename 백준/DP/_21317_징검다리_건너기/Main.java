package 백준.DP._21317_징검다리_건너기;

/*
dp, 재귀

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
재귀 bottom up

- 깊이로 탐색하면서 리프노드에 도달 하였을 때 더한 값들을 return
- 각 리프에서의 합들 중 가장 작은 값을 출력
- superjump(2칸 뛰기)는 boolean메서드로 딱 한번만 사용할 수 있게 끔 제작.
보통 dp 사용하면 리프노드 찍고 하나하나 만들어가는 방식. but, 여기서는 계속 실패하고 잘 안됨.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

         int[][] arr = new int[N + 1][2];
//        int[][] memo = new int[N + 1][2]; // 자식에 superjump 없을 때, 있을 떄

        for (int i = 0; i < N - 1; i++) {
            String[] inputS = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputS[0]);
            arr[i][1] = Integer.parseInt(inputS[1]);
        }

        int K = Integer.parseInt(br.readLine());

        int result = dp(0,true,0, N -1, arr, K);

        System.out.println(result);
    }

    private static int dp(int num, boolean canSuperJump,int result, int maxNum, int[][] arr, int K){
        int minResult;
        if(maxNum < num) return 987654321;
        if(maxNum == num) return result;

        minResult = Math.min(
            dp(num + 1, canSuperJump, result + arr[num][0], maxNum, arr, K),
            dp(num + 2, canSuperJump, result + arr[num][1], maxNum, arr, K)
        );

        if(canSuperJump){
            minResult = Math.min(
                    dp(num + 3, false, result + K, maxNum, arr, K),
                    minResult
            );
        }
        return minResult;
    }
}