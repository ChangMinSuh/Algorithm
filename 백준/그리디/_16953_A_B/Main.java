package 백준.그리디._16953_A_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
구현..? 그리디인지 모르겠음

A => B로 바꿔야하는 문제
이를 거꾸로 풀어나가면 된다.
끝자리가 1이라면 나누기 10을 해준다.(소수점 X)
끝자리가 짝수라면 나누기 2를 해준다.
그 외의 숫자라면 잘못된 정답.
A가 B보다 크다면 잘못된 정답.

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputN[] = br.readLine().split(" ");
        int A = Integer.parseInt(inputN[0]);
        int B = Integer.parseInt(inputN[1]);
        int result = 1;

        while(A < B){
            result++;
            if(B % 10 == 1) { // 마지막 자리가 1일때
                B /= 10;
                continue;
            }
            if(B % 2 != 0) { // 1을 제외한 홀수일떄
                System.out.println(-1);
                return;
            }
            B /= 2;
        }
        // A > B라면 실패!
        System.out.println(
                A == B ? result : -1
        );
    }
}
