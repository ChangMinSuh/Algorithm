package 백준.문자열._20291_파일정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
문자열, Map

- split으로 확장자를 받는다.
- Map을 사용하여 확장자명을 key로, 개수를 value로 받는다.
- key의 집합을 array로 변환 후 sort하여 순서대로 출력한다.

- Treemap을 사용하면 굳이 정렬을 하지 않아도 된다. 심지어 더 빠르다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            String extension = line.split("[.]")[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        String[] mapKeys = map.keySet().toArray(new String[0]);
        Arrays.sort(mapKeys);
        for(String key : mapKeys){
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.println(sb);
    }
}
