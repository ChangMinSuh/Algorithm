import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N;
        int count = 1;

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(br.readLine());
            if (stack.empty()){ // 스택이 비어있다면 채워 넣는다.
                if (N < count) { // 더 넣을 숫자가 없으면 끝.
                    System.out.println("NO");
                    return;
                }
                stack.push(count++);
                sb.append("+\n");
            }

            if(num < stack.peek()) { // 스택 peak값이 입력값보다 높다면 오류
                System.out.println("NO");
                return;
            }

            else if(num == stack.peek()) { // 스택 peak값이 입력값과 같다면 pop.
                sb.append("-\n");
                stack.pop();
                continue;
            }

            if(num < count){ // stack에 넣어야 할 값이 입력받은 수보다 크면 오류.
                System.out.println("NO");
                return;
            }
            for(int j = count; j <= num ; j++){ //입력값이 나올떄까지 push
                stack.push(count++);
                sb.append("+\n");
            }
            stack.pop(); //
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}