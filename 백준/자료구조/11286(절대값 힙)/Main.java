import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        // 우선순위 자료구조(절대값으로 오름차순, 절대값이 같다면 같은 수에서 오름차수)
        // 람다함수 사용(Javascript 화살표함수와 유사한듯..?)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(((o1, o2) ->
                Math.abs(o1) - Math.abs(o2) == 0
                        ? o1 - o2
                        : Math.abs(o1) - Math.abs(o2)
        ));

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            int inputN = Integer.parseInt(br.readLine());

            if(inputN == 0) {
                if(pq.isEmpty()){ // 에러 방지
                    sb.append("0\n");
                    continue;
                }
                sb.append(pq.remove()).append("\n"); // 출력
                continue;
            }

            pq.add(inputN); // 삽입
        }

        System.out.println(sb);
    }
}
