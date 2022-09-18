package 백준.백트래킹._1174_줄어드는_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백트래킹

- dfs 생성
    - 자리수를 기준으로 오름차순으로 '줄어드는 수'를 구해줌
    - 중간에 정답이 나오면 true 반환.
- dfs를 1 자리수부터 10 자리수 까지 검사.
    - true가 한번도 나오지 않으면 -1 출력.

 */

public class Main {
    static int N; // 최종 줄어드는 수.
    static int cnt = 0; // 줄어드는 수를 하나하나 카운트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 1자리수부터 10 자리수까지 검사.
        for(int i = 1; i < 10; i++ ){
            boolean isSuccess = dfs(10, 0, i, "");
            if(isSuccess) return;
        }

        // 작은 수가 초과한 경우
        System.out.println(-1);
    }


    // 자리수(digit)를 기준으로 오름차순으로 '줄어드눈 수'를 구해줌
    public static boolean dfs(int now, int digitCnt, int digit, String resultStr){
        if(digitCnt == digit){
            cnt++;
            if(N == cnt){ // 최종 정답.
                System.out.println(resultStr);
                return true;
            }
            return false;
        }

        for(int i = 0; i <= 9; i++){
            if(now <= i) break;
            boolean isSuccess = dfs(i, digitCnt + 1, digit, resultStr + i);
            if(isSuccess) return true;
        }
        return false;
    }
}
