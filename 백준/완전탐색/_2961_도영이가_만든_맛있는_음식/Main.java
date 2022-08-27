package 백준.완전탐색._2961_도영이가_만든_맛있는_음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
완전 탐색(재귀)

- 재귀를 이용하여 하나하나 검색하며 푼다.
 */

public class Main {
    static int N;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        func(-1, 1, 0);

        System.out.println(result);
    }

    static void func(int index, int mul, int sum){
        if(index >= N) return; // 사용하지 않아도 된다.

        // 0 ~ N-1까지 돌기 위해 첫 index인자를 -1로 삽입.
        for(int i = index + 1; i < N; i++){
            // new 변수를 각각 두어 for문마다 다르게 적용해줌.
            int newMul = arr[i][0] * mul;
            int newSum = arr[i][1] + sum;
            result = Math.min(result, Math.abs(newMul - newSum));
            func(i, newMul, newSum);
        }

    }

}
