package 백준.투포인터._20922_겹치는_건_싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
토포인터, map

- 투포인터를 사용하여 하나하나 검사
    - start, end
    - end가 한칸씩 앞으로 가면서 최대길이 저장.
    - arr[end] 원자의 개수가 최대 원자 수 보다 커진다면
        - arr[end]가 K가 될떄까지 start를 한칸씩 앞으로 옮김.
    - end가 끝까지 간다면 종료
        - 최대값은 이미 나왔고, start가 줄어들 일만 남았으므로..
- map변수 사용
    - 각 원자의 같은 값이 몇개인지 저장
    - key: arr[i]
    - value: 개수
- map보단 범위를 정해서 배열을 사용하는 것이 코테기준 메모리, 시간이 빠르다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] countArr = new int[100005];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int result = 0;
        while(end < N){
            if(countArr[arr[end]] >= K){ // arr[end]의 개수가 최대치(K)인 경우
                // arr[start]가 endMapValue 와 같을 떄 까지 start + 1 하면서 반복문
                do{
                    countArr[arr[start]]--;
                    start++;
                }while(arr[start - 1] != arr[end]);
            }
            // start 조정 후 정상 작동.
            // 모든 원소가 K이하일때,
            countArr[arr[end]]++;
            end++;
            result = Math.max(result, end - start);
        }
        System.out.println(result);
    }
}

