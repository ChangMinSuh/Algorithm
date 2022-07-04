import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
전체를 다 탐색
N * N => 1,000,000 * 1,000,000 => 10억 훨심넘음.
TreeMap 사용
- N: 최대 나무 갯수, M: 최대 종류
- NlogM => 1,000,000 * 100 => 100,000,000  1억. 조금 아슬아슬하긴 함.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();

        String inputS = "";
        int sum = 0;
        Map<String, Integer> map = new TreeMap<String,Integer>();

        while((inputS = br.readLine()) != null){
            map.put(inputS, map.getOrDefault(inputS,0) + 1);
        }

        for(int key : map.values()){
            sum += key;
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            float distribution = Math.round((float)entry.getValue() / (float)sum * 100 * 10000) / (float)10000;
            // 10.0과 같은 숫자도 4자리 소수점까지 표현하기 위해 String.format 사용. (참고함)
            sb.append(entry.getKey())
                    .append(" ")
                    .append(String.format("%.4f", distribution))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
