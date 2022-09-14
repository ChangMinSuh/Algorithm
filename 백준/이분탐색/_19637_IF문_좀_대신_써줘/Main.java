package 백준.이분탐색._19637_IF문_좀_대신_써줘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
이분 탐색

- 배열로 이름, power를 각각 받음

- 캐릭터 전투력 당 이분탐색 한번 실행
    - 작거나 같다면, right = mid - 1
        - 같다면? 해당하는 칭호가 같다면 가장 먼저 입력된 칭호 하나 출력이기 때문.
    - 크다면 left = mid + 1

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] name = new String[N];
        int[] power = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.valueOf(st.nextToken());
        }

        while(M-- > 0){
            int num = Integer.parseInt(br.readLine());
            int left = 0, right = N - 1;
            int mid = 0;

            while(left <= right){
                mid = (left + right) / 2;

                // 작거나 같다면
                if(num <= power[mid]){
                    right = mid - 1;
                    continue;
                }
                // 크다면
                left = mid + 1;
            }
            sb.append(name[left]).append("\n");
        }
        System.out.println(sb);
    }
}
