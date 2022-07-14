package 백준.자료구조._2504_괄호의_값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>(); // 왼쪽 괄호 저장.
        String inputS = br.readLine();
        int addNum = 1;
        int result = 0;
        boolean canAddNum = true;

        for (int i = 0; i < inputS.length(); i++) {
            char item = inputS.charAt((i));
            switch (item) {
                case '(':
                    stack.push('(');
                    addNum *= 2;
                    canAddNum = true;
                    break;
                case '[':
                    stack.push('[');
                    addNum *= 3;
                    canAddNum = true;
                    break;
                case ')':
                    if (stack.empty()  || stack.pop() != '(') { // 잘못된 괄호
                        System.out.println(0);
                        return;
                    }
                    if (canAddNum) result += addNum; // 오른쪽 괄호가 연속이면 덧셈 X
                    addNum /= 2;
                    canAddNum = false;
                    break;
                case ']':
                    if (stack.empty()  || stack.pop() != '[') { // 잘못된 괄호
                        System.out.println(0);
                        return;
                    }
                    if (canAddNum) result += addNum; // 오른쪽 괄호가 연속이면 덧셈 X
                    addNum /= 3;
                    canAddNum = false;
                    break;
            }
        }

        sb.append(stack.empty() ? result : 0);
        System.out.println(sb);
    }
}
