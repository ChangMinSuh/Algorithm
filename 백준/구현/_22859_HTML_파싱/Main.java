package 백준.구현._22859_HTML_파싱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> codes  = Arrays.stream(br.readLine().split(" *<")).map(item -> "<" + item).collect(Collectors.toList());

        Iterator<String> it = codes.iterator();
        while(it.hasNext()){
            // 앞뒤 공백제거,
            String code = it.next().trim();
            if(code.indexOf("<div")== 0){
                String[] token = Arrays.stream(code.split(" +|=\"")).map(String::trim).toArray(String[]::new);
                sb.append(token[1]).append(" : "); // title
                for(int i = 2; i <token.length; i++)
                    sb.append(token[i]).append(" ");
                sb.setLength(sb.length() - 3);
                sb.append("\n");
            }
            else if (code.indexOf("<p>") == 0) {
                do{
                    if(code.indexOf("</p>") == 0){ // 끝
                        sb.setLength(sb.length() - 1);
                        sb.append("\n");
                        break;
                    }
                    System.out.println(code);
                    System.out.println();
                    String[] token = Arrays.stream(code.split(">| +")).map(String::trim).toArray(String[]::new);
                    for(String item: token)
                        System.out.println(item);
                    System.out.println();
                    for(int i = 1; i < token.length; i++){
                        if(token[i].trim().equals("")) continue;
                        sb.append(token[i]).append(" ");
                    }
                    code = it.next().trim(); // 다음 코드

                } while(it.hasNext());
            }
        }
        System.out.println(sb.toString().trim());
    }
}
