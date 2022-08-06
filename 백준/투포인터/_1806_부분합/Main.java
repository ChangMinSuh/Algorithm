package 백준.투포인터._1806_부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
투포인터

- 우선 한자리(arr[end])를 sum에 더한다.
- 연속된 부분합이 최소 합(S)를 넘기면 최소 합(S)보다 작아질 때 까지 start + 1, result 업데이트.
- 나머지는 end + 1.
- 주의
    - 값이 없을 때 0 출력 주의

 */

public class Main {
    public static void main(String[] args) throws IOException {
        final int MAX_NUM = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int sum = 0, result = MAX_NUM;

        while(end < N){
            // 한자리를 sum에 더한다.
            sum += arr[end];
            end++;
            // 총 합이 S보다 작은 경우
            if(sum < S) continue;

             // S 와 같거나 큰경우
            do{   // S보다 작아질떄 까지 start + 1
                sum -= arr[start];
                start++;
            } while(sum >= S);

            result = Math.min(result, end - (start - 1)); // S보다 작기 바로 전 길이를 출력.
        }

        System.out.println(result == MAX_NUM ? 0 : result);
    }
}
