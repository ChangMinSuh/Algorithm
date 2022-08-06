package 백준.투포인터._22862_가장_긴_짝수_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
투포인트

 - 투포인트를 사용하여 연속된 모든 경우를 체크한다.
 - 짝수
  - 짝수 개수 + 1, enㅇ + 1
 - 홀수 =>
  - K보다 작다면
    - end + 1, 홀수개수 + 1
  - K보다 크다면
    - 홀수가 나올떄까지 start + 1, 짝수개수 - 1
    - 홀수가 나오면 end++.

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int front = 0, end = 0;
        int oddCnt = 0, evenCnt = 0, result = 0;
        while(end < N){
            if(arr[end] % 2 != 0){ // 홀수
                if(oddCnt < K) { // K보다 작다면
                    oddCnt++;
                    end++;
                    continue;
                }
                // 이미 K보다 크거나 같다면
                while(arr[front] % 2 == 0){ // 홀수가 나올떄까지 반복문.
                    evenCnt--;
                    front++;
                }
                front++;
                end++;
                continue;
            }
            // 짝수
            evenCnt++;
            end++;
            result = Math.max(result, evenCnt);
        }
        System.out.println(result);
    }
}
