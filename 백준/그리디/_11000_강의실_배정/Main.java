package 백준.그리디._11000_강의실_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
그리디

시작하는 시간대별로 최적화를 하여 겹치는 시간이 있다면 방을 하나 추가한다.

2차원 배열을 정렬한다
    - (오류) --times[][1] 오름차순. 같다면, times[][0] 오름차순--
    - times[][0] 오름차순.
        - 강의실이 가장 먼저 비는 시간과 새로운 회의의 시작 시간을 비교하기에, 시작 시간을 기준으로 오름차순.
배열을 순차적으로 수행
    - 각 교실의 마지막 시간들을 우선순위 큐에 모아둠.
        - remove한 값이 가장 일찍 끝나는 회의 시간.
    - 교실중 가장 빨리 끝나는 시간이 새로운 화의랑 같거나 빠르다면, 교실 추가하지 않고 이어서 가능.
        - qu.remove()
    - 새로운 회의의 마지막 시간을 큐에 추가해줌.
        - qu.add()
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int times[][] = new int[N][2];
        for(int i = 0; i < N; i++){
            String input[] = br.readLine().split(" ");
            times[i][0] = Integer.parseInt(input[0]);
            times[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> qu = new PriorityQueue<>(); //각 교실의 마지막 시간들을 모아둠.
        qu.add(0); // 초기화.

        for(int i = 0; i < N; i++){
            if(qu.peek() <= times[i][0]){
                qu.remove();
            }
            qu.add(times[i][1]);

        }
        System.out.println(qu.size());
    }
}
