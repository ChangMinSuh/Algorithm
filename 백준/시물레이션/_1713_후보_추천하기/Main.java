package 백준.시물레이션._1713_후보_추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
map, 구현

- map 사용
    - key: 학생번호
    - value
        - 들어온 순서, 추천 수
- 추천받은 사진을 map에 넣음
    - 기존에 존재한다면 추천수 + 1
    - 없다면
        - 꽉 찬 상태라면 조건에 맞는 사진 삭제
        - 사진 추가.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int createRank = 1;
        Map<Integer, MapData> map = new HashMap<>();
        while(M-- > 0){
            int input = Integer.parseInt(st.nextToken());
            // map에 있다면
            if(map.containsKey(input)) {
                MapData mapData = map.get(input);
                mapData.voteCnt++;
                map.put(input, mapData);
                continue;
            }

            // map에 없다면

            // 새로운 사진 무조건 넣어야하니 꽉 찼는지 체크
            if(map.size() >= N){
                int removeKey = 0;
                MapData removeMapData = new MapData(10000, 10000);
                for(int key : map.keySet()){
                    MapData mapData = map.get(key);
                    if(mapData.voteCnt < removeMapData.voteCnt // 투표수가 적을때.
                            || mapData.voteCnt == removeMapData.voteCnt // 투표수가 같다면 더 먼저 들어 왔을 때
                            && mapData.createRank < removeMapData.createRank){
                        removeKey = key;
                        removeMapData = mapData;
                    }
                }
                map.remove(removeKey); // 조건에 맞는 사진 삭제.
            }

            // map에 추가
            map.put(input, new MapData(createRank++, 1));

        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> o1 - o2);
        for(int key : list){
            sb.append(key).append(' ');
        }
        System.out.println(sb);
    }

    static class MapData{
        int createRank; // 들어온 순서
        int voteCnt; // 추천 수

        public MapData(int createRank, int voteCnt) {
            this.createRank = createRank;
            this.voteCnt = voteCnt;
        }
    }
}
