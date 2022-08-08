package 백준.투포인터._20366_같이_눈사람_만들래;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
정렬, 구현

- 모든 경우의 눈사람길이를 구하고, 정렬한 후, 두개씩 비교하여 가장 작은값 출력. 이때, 같은 눈덩이는 제외.
- 시간초과 날 것이라 생각하고 돌렸는데 맞았다.
---
- list에는 눈사람을 만들 수 있는 모든 경우의 값을 삽입한다. (최대 600x599 / 2 = 179,700, 거의 180,000)
- list는  ListData라는 클래스를 타입으로 사용한다
  - ListData
    - data: 두 지름을 더한 값
    - index1: 하나의 눈덩이
    - index2: 또 다른 눈덩이
- list를 정렬한다. (O(NlogN), 대략 180,000 * log(180,000) = 3,142,375)
- for문을 돌려 인접한 눈사람을 비교한다. (O(N), 대략 180,000)
  - 인접한 눈사람 길이의 차 중 가장 작은 값이 정담.
  - 이때, 각 눈덩이는 달라야한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; // 지름의 값들
        List<ListData> list = new ArrayList<>(); // 눈사람의 모든 경우의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 눈사람 경우 저장.
        for(int i =0; i <N; i++){
            for(int j = i + 1; j < N; j++){
                list.add(new ListData(arr[i] + arr[j], i, j));
            }
        }

        // 정렬
        // list.sort((o1, o2) -> o1.data - o2.data))와 같다.
        list.sort(Comparator.comparingInt(o -> o.data));

        // 인접한 눈사람 비교
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++){
            ListData listData1 = list.get(i);
            ListData listData2 = list.get(i + 1);

            // 같은 눈덩이 제외
            if(listData1.index1 == listData2.index1
            || listData1.index2 == listData2.index1
            || listData1.index1 == listData2.index2
            || listData1.index2 == listData2.index2) continue;

            result = Math.min(result, listData2.data - listData1.data);
        }

        System.out.println(result);
    }
}

class ListData {
    int data;
    int index1;
    int index2;

    public ListData(int data , int index1, int index2){
        this.data = data;
        this.index1 = index1;
        this.index2 = index2;
    }
}