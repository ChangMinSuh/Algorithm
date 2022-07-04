import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        // 우선순위 자료구조(반대로 정렬: 높은수 => 낮은수) 람다함수 사용 가능.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int inputN = Integer.parseInt(br.readLine());

            if(inputN == 0){
                if (pq.isEmpty()){ // 우선순위 큐가 비어있을때 remove()하면 에러발생. 0 출력
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
