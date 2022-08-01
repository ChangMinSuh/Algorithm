package 백준.DP._12865_평범한_배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
dp

- meme
  - index: 무계
  - value: 가치 값.
각 물건을 순회하면서 dp의 무계를 최대치부터 물건 무계까지 하나씩 업데이트.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arrW = new int[N];
        int[] arrV = new int[N];

        int[] memo = new int[K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arrW[i] = Integer.parseInt(st.nextToken());
            arrV[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= arrW[i]; j--) {
                memo[j] = Math.max(memo[j], memo[j - arrW[i]] + arrV[i]);
            }
        }
        System.out.println(memo[K]);
    }
}
