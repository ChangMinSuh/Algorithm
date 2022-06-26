import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        char[] inputArr = new char[input.length()];
        for(int i = 0; i < input.length(); i++) inputArr[i] = input.charAt(i);
        Set<String>resultSet = new TreeSet<String>();

        func(input.length(), inputArr, 0, "", new Stack(), resultSet);

        for(String item: resultSet) sb.append(item).append('\n');

        System.out.println(sb.substring(sb.indexOf("\n") + 1));
    }

    /**
     *
     * @param inputLength 입력받은 수식의 길이
     * @param inputArr 입력받은 값 배열로 재정의
     * @param cnt
     * @param result 재귀를 사용한 출력값.
     * @param isParenthesis '('사용 유뮤 Stack으로 정의
     * @param resultSet TreeSet을 통해 결과값 중복 제거 및 정렬
     */
    public static void func(int inputLength, char[] inputArr, int cnt , String result, Stack<Boolean> isParenthesis, Set<String> resultSet){

        // 재귀 종료
        if (cnt >= inputLength) {
            resultSet.add(result);
            return;
        }

        // ')'의 재귀는 따로 제작
        if (inputArr[cnt] == ')') {
            func(inputLength, inputArr, cnt + 1, isParenthesis.pop() ? result + inputArr[cnt] : result , (Stack)isParenthesis.clone() , resultSet);
            return;
        }

        // '(' 추가한 재귀
        if(inputArr[cnt] == '('){
            isParenthesis.push(true);
        }
        func(inputLength, inputArr, cnt + 1, result + inputArr[cnt], (Stack) isParenthesis.clone(), resultSet);

        // '(' 미추가한 재귀
        if(inputArr[cnt] == '('){
            isParenthesis.pop();
            isParenthesis.push(false);
            func(inputLength, inputArr, cnt + 1, result, (Stack) isParenthesis.clone(), resultSet);
        }

    }
}
