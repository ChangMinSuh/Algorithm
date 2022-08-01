package 백준.DP._9251_LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
LCS, 2차원 dp

- 2차원 dp 이용
- for문으로 2차원 배열을 행렬 순서대로 탐색
    - 작은 부분배열에서 큰 부분배열로 넘어감
        - (C, A) => (C, AC) -> ...-> (CA, A) -> ... -> (CAPCAK, ACAYKP)
    - memo의 위 vs 왼쪽 중 가장 큰 값을 저장
        - 현재 memo는 전의 memo를 이어 받기 때문.
        - memo[y][x] = Math.max(memo[y][x - 1], memo[y - 1][x]);
    - 만약 현재 인덱스의 문자가 같다면, 저장된 값 vs 왼쪽 위 + 1중 큰값.
        - memo[y][x] = Math.max(memo[y][x], memo[y-1][x-1] + 1)

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] string1 = br.readLine().toCharArray();
        char[] string2 = br.readLine().toCharArray();
        int[][] memo = new int[string2.length + 1][string1.length + 1];

        for (int y = 1; y <= string2.length; y++) {
            for (int x = 1; x <= string1.length; x++) {
                memo[y][x] = Math.max(memo[y][x - 1], memo[y - 1][x]);
                if (string1[x - 1] != string2[y - 1]) continue;
                memo[y][x] = Math.max(memo[y][x], memo[y-1][x-1] + 1);
            }
        }
        System.out.println(memo[string2.length][string1.length]);
    }
}
