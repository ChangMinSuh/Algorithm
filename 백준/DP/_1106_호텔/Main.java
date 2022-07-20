package 백준.DP._1106_호텔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
dp, 재귀(Top-Down)

- 원하는 사람수(C)를 기준으로, 지역마다의 고객수들을 뺴면서 Dp를 해준다
    - 12 -> 7 -> 2 -> 1 -> 0 ...
- 노드의 차수가 N이므로 for문을 통해 검사한다.
- 원하는 사람 수 만큼 채우거나 **초과하면** return 0
- 재귀가 복귀하면서 return + 드는 비용을 생성한다.
    - 이때, 생성된 수 중에서 가장 작은 값을 메모이제이션에 추가.
- 가장 인덱스가 큰 메모이제이션을 출력.

- 주의
    - 초과해도 됌
 */

public class Main {
    static final int VERY_BIG_NUMBER = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNC = br.readLine().split(" ");
        int C = Integer.parseInt(inputNC[0]); // 호텔에서 늘려야하는 고객 수
        int N = Integer.parseInt(inputNC[1]); // 도시의 개수
        int[][] arr = new int[N][2]; // 도시에서 홍보할 때 대는 비용, 얻을 수 있는 고객의 수.
        int[] memo = new int[C + 1];
        Arrays.fill(memo, VERY_BIG_NUMBER);

        for(int i = 0; i < N; i++){
            String[] inputNum = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputNum[0]);
            arr[i][1] = Integer.parseInt(inputNum[1]);
        }

        int result = dp(C, N, arr, memo);
        System.out.println(result);
    }

    static private int dp(int C, int N, int[][] arr, int[] memo){
        if(C <= 0) return 0;
        //if(C < 0) return VERY_BIG_NUMBER;

        if(memo[C] != VERY_BIG_NUMBER) return memo[C];

        // min
        for(int i = 0; i < N; i++){
             int cost = arr[i][0];
             int people = arr[i][1];
             int answer = dp(C - people, N, arr, memo) + cost;
             if(answer < memo[C]) memo[C] = answer;
        }
        return memo[C];
    }
}

