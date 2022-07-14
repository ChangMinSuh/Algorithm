package 백준.그리디._21314_민겸_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
그리디?

k는 무조건 뒤에만 올 수 있음.
mk: 50, m / k = 15
mm: 10, m / m = 11

최댓값
    - k가 나올떄까지 m을 붙인다 ex) mmk, mmmk, mmmmmk
    - 마지막 자리에 k가 없다면 각각 따로 출력. ex) mkmm
최솟값
    - k는 1자리수, M은 최대한 길게 하면 된다.

int로 하면 넘어감!!!! 주의!!!!!!!!
    - 길이가 3000이기 때문.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        char[] characters = new char[line.length()];

        for(int i = 0; i < line.length(); i++){ // char 배열 변환
            characters[i] = line.charAt(i);
        }

        // 최대값
        System.out.println(maxSolved(characters, sb));
        // sb 초기화
        sb.setLength(0);
        // 최솟값
        System.out.println(minSolved(characters, sb));
    }

    static String maxSolved(char[] characters, StringBuilder sb){
        String tmpSum = "1"; // 더해주는 값

        for(char character: characters){
            // M
            if(character == 'M'){
                tmpSum += "0";
                continue;
            }
            // K
            tmpSum = tmpSum.replace('1','5');
            sb.append(tmpSum);
            tmpSum = "1";
        }
        // 마지막이 M일 경우에는 tmpSum에 남아있어 연산작업 필요.
        // 마지막 자리에 k가 없다면 각각 나눠서 출력. ex) mm => m / m
        if(tmpSum != "1"){
            // 1000 < 1111 이게 더 크다. mmmm < m/m/m/m
            tmpSum = tmpSum.replace('0','1');
            sb.append(tmpSum).deleteCharAt(sb.length() - 1); // tmpSum이 10배 더 크다.
        }
        return sb.toString();
    }

    static String minSolved(char[] characters, StringBuilder sb){
        String tmpSum = "1"; // M값을 더해줌

        for(char character: characters){
            // M
            if(character == 'M'){
                tmpSum += "0";
                continue;
            }
            // K
            if(tmpSum != "1"){ // 앞에 M이 없다면, 넣으면 안된다.
                sb.append(tmpSum).deleteCharAt(sb.length() - 1); // tmpSum이 10배 더 크기 떄문에 10 나눠줘야한다.
            }
            sb.append('5');
            tmpSum = "1";
        }
        if(tmpSum != "1"){
            sb.append(tmpSum).deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
