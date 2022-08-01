package 백준.DP._5557_1학년;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
map, bfs?, dp?

- bfs로 피연산자 하나하나 + 와 - 해준다.
    - 이때, 중복되는 부분의 개수를 적어주기 위해 qu대신 map을 사용한다.
        - <결과 값, 다향식 개수>
        - ex)
        - (3, 1) => 1 => (4, **2**, 0)
        - 이때 2는 2가지 방법. (3 - 1, 1 + 1).
        - 이런경우를 map에 (2, 2)로 저장.
- 주의
    - long 사용.
    - 중간에 가능한 수는 0 ~ 20의 수이다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer,Long> map = new HashMap<>(); // memo
        map.put(arr[0], 1L); // start
        for(int i = 1; i < N - 1; i++){
            Map<Integer, Long> pushMap = new HashMap<>(); // 새로운 맵
            Map<Integer, Long> copyMap = Map.copyOf(map); // 반복문을 위한 복사맵
            for(int key: copyMap.keySet()){
                Long nowValue = map.remove(key);
                if(key + arr[i] <= 20){ // +
                    pushMap.put(
                            key + arr[i],
                            pushMap.getOrDefault(key + arr[i],0L) + nowValue
                    );
                }
                if(0 <= key - arr[i]) { // -
                    pushMap.put(
                            key - arr[i],
                            pushMap.getOrDefault(key - arr[i], 0L) + nowValue
                    );
                }
            }
            map.putAll(pushMap);
        }

        System.out.println(map.getOrDefault(arr[N - 1], 0L));
    }
}
