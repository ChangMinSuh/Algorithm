package 백준.문자열._17609_회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문자열

- 양쪽 인덱스에서 하나하나 검사.
- 같으면 continue
- 다르면 양쪽에서 하나씩 해보면서 검사 (화문 체크)
- 화문 체크시, 양쪽 중 둘 다 화문 가능성이 있을 때는 두 경우 다 검사해야한다.
    - ex ) xabaxa
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            String str = br.readLine();
            int startIdx = 0, endIdx = str.length() - 1;
            int tmpStartIdx = -1, tmpEndIdx = -1;
            int moveMore = 0; // 회문인지 체크

            while(startIdx < endIdx){
                if(str.charAt(startIdx) != str.charAt(endIdx)){
                    // 이미 한 칸 이동한 적이 있다면 일반 문자열
                    if(moveMore > 0){
                        // 화문체크에서 두 경우가 존재했다면,
                        if(tmpStartIdx > -1){
                            startIdx = tmpStartIdx; endIdx = tmpEndIdx;
                            tmpStartIdx = -1;
                            continue;
                        }
                        sb.append(2).append('\n');
                        moveMore = 100; // 회문이 아니라는 뜻.
                        break;
                    }

                    // 회문인지 체크
                    if(str.charAt(startIdx + 1) == str.charAt(endIdx)){
                        // 두가지 경우 체크.
                        if(str.charAt(startIdx) == str.charAt(endIdx - 1)){
                            // tmp로 나중에 다시 시도.
                            tmpStartIdx = startIdx; tmpEndIdx = endIdx - 1;
                        }
                        startIdx++;
                        moveMore++;
                    }
                    else if(str.charAt(startIdx) == str.charAt(endIdx - 1)){
                        endIdx--;
                        moveMore++;
                    }
                    else{ // 하나를 줄여도 회문이 되지 않음.
                        // 화문체크에서 두 경우가 존재했다면,
                        if(tmpStartIdx > -1){
                            startIdx = tmpStartIdx; endIdx = tmpEndIdx;
                            tmpStartIdx = -1;
                            continue;
                        }
                        sb.append(2).append('\n');
                        moveMore = 100; // 회문이 아니라는 뜻.
                        break;
                    }
                }
                startIdx++; endIdx--;
            }
            if(moveMore > 1) continue;

            sb.append(moveMore).append("\n");
        }
        System.out.println(sb);
    }
}
