package 백준.문자열._9342_염색체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문자열, 구현

- 맨첫번쨰와 맨 끝 문자가 각각 b,c,d,e,f | a,b,d,e,f와 같다면 그 부분을 제외하여 탐색한다.
- a,f,c의 배열과 해당 순서대로 잘 이루어 지는지 조건을 추가하며 구현한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] chkStr = {'A', 'F', 'C'};
        while(N-- > 0){
            String str = br.readLine();
            // 'A', 'F', 'C'가 몇번씩 나왔는지 체크
            int[] chkStrCnts = new int[3];
            int startIdx = 0, endIdx = str.length() - 1, chkStrIdx = 0;
            // 처음 필터
            if(
                    str.charAt(startIdx) == 'B' ||
                    str.charAt(startIdx) == 'C' ||
                    str.charAt(startIdx) == 'D' ||
                    str.charAt(startIdx) == 'E' ||
                    str.charAt(startIdx) == 'F'
            )
                startIdx++;
            // 마지막 필터
            if(
                    str.charAt(endIdx) == 'A' ||
                    str.charAt(endIdx) == 'B' ||
                    str.charAt(endIdx) == 'D' ||
                    str.charAt(endIdx) == 'E' ||
                    str.charAt(endIdx) == 'F'

            )
                endIdx--;

            boolean isSuccess = true;

            for(int i = startIdx; i <= endIdx; i++){
                if(chkStr[chkStrIdx] == str.charAt(i)) {
                    chkStrCnts[chkStrIdx]++;
                    continue;
                }
                if(chkStrCnts[chkStrIdx] == 0){ // A, F, C가 한번도 사용하지 않았다면,
                    isSuccess = false;
                    sb.append("Good\n");
                    break;
                }
                chkStrIdx++;
                if(chkStrIdx == 3 || chkStr[chkStrIdx] != str.charAt(i)) {
                    sb.append("Good\n");
                    isSuccess = false;
                    break;
                }
                chkStrCnts[chkStrIdx]++;
            }
            if(isSuccess)
                sb.append("Infected!\n");
        }
        System.out.println(sb);
    }
}
