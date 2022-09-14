package 백준.이분탐색._2110_공유기_설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 이분탐색을 이용해 정답을 추정
        // 매개변수 탐색
        int left = 0, right = arr[N - 1];

        while(left <= right){
            int mid = (left + right) / 2;

            // 첫 인덱스부터 mid만큼의 거리가 얼만큼 가능한지 cnt로 샘
            int cnt = 1, startIdx = 0;
            for(int i = 1; i < N ;i++){
                // 사이으 거리가 mid 미만일 때
                if(arr[i] - arr[startIdx] < mid){
                    continue;
                }
                startIdx = i; cnt++;
            }
            // cnt 보다 작다면 정답 예상치를 낮춰야 한다.
            if(cnt < C){
                right = mid - 1;continue;
            }
            left = mid + 1;
        }

        System.out.println(right);
    }
}

// 1, 2, 4, 8, 9
// 1, 2, 4, 1

// 1, 2, 3, 7, 9