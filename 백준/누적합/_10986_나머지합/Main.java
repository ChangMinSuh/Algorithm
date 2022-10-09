package 백준.누적합._10986_나머지합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
누적합, 해시맵


- 누적합을 만들고 하나하나씩 계산하면 정답. 하지만 시간초과
  - ex) sum[] = {2, 0, 2, 0} M = 3;
  - 0 ~ N = sum[0], sum[1], sum[2], sum3[3]. 각각 M으로 나눠서 0이 나오면 출력
  - 1 ~ N = sum[1], sum[2], sum[3] 에 sum[0] 빼줌. 각각 M으로 나눠서 0이 나오면 출력
  - 2 ~ N = sum[2], sum[3] 에 sum[1] 빼줌. 각각 M으로 나눠서 0이 나오면 출력
  - 결국 2중 포문으로 시간초과..

- 역으로 M 값을 움직이면 됨. sum과 map은 그대로 두고, 가져올 값을 바꿈.
  - 0 ~ N = sum[0], sum[1], sum[2]. sum3[3]. 이떄 각 sum을 % M 하여 map에 저장.
    - map에 sum의 결과(key)와 개수(value)를 저장 후,  0인경우가 나눠 떨어진 경우이다.
  - 1 ~ N = sum[1], sum[2], sum[3]
    - map의 값을 변경하는 대신 나눌 값을 변경한다.
      - (전에 나눈값 + sum[0]) % M => 이값을 map에서 get하면 그값이 나눠 떨어지는 수이다.

  - 2 ~ N  도 위처럼 반복

- sum변수를 이용해 누적합 저장
- sumMap변수를 이용해 누적합의 개수를 저장

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        long[] sum = new long[N + 1];
        Map<Long, Integer> sumMap = new HashMap<>();

        for(int i = 1; i <= N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = (sum[i - 1] + arr[i]) % M;
            sumMap.put(sum[i], sumMap.getOrDefault(sum[i],0) + 1);
        }

        long result = 0;
        long targetM = M;

        for(int i = 1; i <= N; i++){
            result += sumMap.getOrDefault(targetM % M, 0);
            targetM = (targetM + arr[i]) % M;
            //역전되는 경우는 없기 때문에 앞에서 하나씩 제거
            sumMap.put(sum[i], sumMap.get(sum[i]) - 1);
        }
        System.out.println(result);
    }
}
