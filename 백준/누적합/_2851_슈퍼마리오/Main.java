package 백준.누적합._2851_슈퍼마리오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 10;
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];

        // init
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + arr[i];
        }

        int result = 0;

        for(int num : sum){
            int tmpNum = Math.abs(num - 100);
            int tmpResult = Math.abs(result - 100);

            // result 보다 100과의 거리가 멀다면 다음으로
            if(tmpResult < tmpNum ) continue;

            result = num;
        }

        System.out.println(result);
    }
}


