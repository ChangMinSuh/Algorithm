package 백준.이분탐색._22871_징검다리_건나기_large;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
dp

- 문제
    - 첫점부터 끝점까지 중 파워가 가장 큰 값이 최소인 값을 구해야한다.
    - 최대의 최소, 최소의 최대는 이분탐색 문제이지만, 방법을 잘 모르겠어서 DP 해결.

- 한칸 한칸 씩 넘어갈 수 있는 최대의 파워 중 최소 값을 memo 배열에 저장.
    - memo[x] : 0 부터 x 까지 도달했을 때 중 파워가 가장 낮은 경로의 가장 쎈 파워.
- 로직
    1. memo[i](이전 돌)의 값과 점프한 파워 중 가장 큰 값을 우선 구한다. (새로운 0 부터 j 까지의 파워 구하기)
        - memo[i]은 0 부터 x 까지 도달했을 때
    2. (1.)의 값과 memo[j] 중 작은 값 구한다.
        - (1.)은 0 부터 j 까지의 새로운 경로. 그 안에서의 파워이다.
        - memo[j]는 기존의 0부터 j 까지의 경로에서 나온 최소의 파워중 최대의 파워이다.
- 위의 로직을 이중 for문을 통해 모두 구해준다.
- memo의 마지막 값이 정답.
- (1.) 과정 중 power를 구하는 과정에서 int 범위를 넘어가니 long 사용.

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        long[] memo = new long[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(memo, 1, memo.length, Long.MAX_VALUE);

        // i => j로 가는 경우를 DP로
        for(int j = 1; j < N; j++){
            for(int i = 0; i < j; i++){
                // 명시적 long을 꼭 사용하자!
                long power =  (j - i) * (long)(1 + Math.abs(arr[i] - arr[j]));
                // i 돌에서 j 돌로 이동할 때 드는 power
                long nowMaxPower = Math.max(power, memo[i]);
                // 기존 파워와 비교
                memo[j] = Math.min(memo[j], nowMaxPower);
            }
        }

        System.out.println(memo[N - 1]);
    }
}
