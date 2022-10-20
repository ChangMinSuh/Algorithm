package 백준.문자열._17413_단어뒤집기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
문자열, stack

- 태그가 아닌 부분은 stack을 사용하고, 빈칸이 나왔을 시에 출력.
- 태그인 부분은 boolean 값을 사용하여 바로바로 출력.

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean tagOn = false;
        for(char item : line.toCharArray()){
            if(item == '<'){
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
                tagOn = true;

            }
            else if(item == '>'){
                tagOn = false;

            }
            else if(item == ' '){
                if(!tagOn)
                    while(!stack.empty()){
                        sb.append(stack.pop());
                    }
            }
            if(tagOn || item == ' ' || item == '>') sb.append(item);
            else stack.push(item);
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
