package 백준.누적합._2015_수들의합_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
누적합, 해시맵


- 누적합을 만들고 하나하나씩 계산하면 정답. 하지만 시간초과
  - ex) sum[] = {2, 0, 2, 0} K = 0;
  - 0 ~ N = sum[0], sum[1], sum[2], sum3[3]. K = 0
  - 1 ~ N = sum[1], sum[2], sum[3] 에 sum[0] 빼줌. K = 0
  - 2 ~ N = sum[2], sum[3] 에 sum[1] 빼줌. K = 0
  - 결국 2중 포문으로 시간초과..
- 역으로 K 값을 움직이면 됨.
  - 0 ~ N = sum[0], sum[1], sum[2]. sum3[3], K = 0
  - 1 ~ N = sum[1], sum[2], sum[3]. K = 0 에 sum[0] 더해줌
  - 2 ~ N = sum[2], sum[3]. 위 K에 sum[1] 더해줌

- sum변수를 이용해 누적합 저장
- sumMap변수를 이용해 누적합의 개수를 저장

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        long[] sum = new long[N + 1];
        Map<Long, Integer> sumMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i - 1];
            // sumMap에 결과값들을 더해줌.
            sumMap.put(sum[i], sumMap.getOrDefault(sum[i],0) + 1);
        }

        long result = 0;
        long targetK = K;

        for(int i = 1; i <= N; i++){
            result += sumMap.getOrDefault(targetK, 0);
            targetK += arr[i];
            sumMap.put(sum[i], sumMap.get(sum[i]) - 1);
        }


        System.out.println(result);


    }
}
