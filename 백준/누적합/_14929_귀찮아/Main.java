package 백준.누적합._14929_귀찮아;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
누적합

- 배열의 누적합을 우선 구한다.
- a1 * a2 + a1 * a3 + a2 * a3
    => a1(a2 + a3) + a2(a3)
    => result += arr[i] * (sum[N] - sum[i]);

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        long[] sum = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i - 1];
        }


        long result = 0;

        for(int i = 1; i < N; i++){
            result += arr[i] * (sum[N] - sum[i]);
        }


        System.out.println(result);
    }
}
