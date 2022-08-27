package 백준.완전탐색._15686_치킨_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
완전탐색, 재귀

- 집과 치킨집의 위치를 각각 입력받음
    - arraylist로 받음.
- distance에 집과 치킨집의 가능한 모든 거리를 저장.
    - 가로: 집, 세로: 치킨집
- distance를 모두 채움
    - x의 차와 y의 차를 더하면 거리가 나옴.
- dfs(재귀)를 통해 완탐
    - 3개씩 나올 때 마다 기저조건에서 도시의 치킨거리 구함.
    - 구한 치킨거리중 최소거리를 구함.
 */
public class Main {
    static public List<YX> homes;
    static public List<YX> chickens;
    static public int[][] distance;
    static public int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        homes = new ArrayList<>(); // 집 모음
        chickens = new ArrayList<>(); // 치킨 모음
        for(int y = 0; y < N; y++){
            st  = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 1)
                    homes.add(new YX(y, x));
                else if(input == 2)
                    chickens.add(new YX(y, x));
            }
        }
        // 치킨집과 집과의 모든 거리를 저장
        // 가로: 집, 세로: 치킨집
        distance = new int[homes.size()][chickens.size()];
        
        // distance arr 채우기
        for(int y = 0; y < homes.size(); y++){
            for(int x = 0; x < chickens.size(); x++){
                YX home = homes.get(y);
                YX chicken = chickens.get(x);
                // 거리 구하여 저장.
                distance[y][x] = Math.abs(home.X - chicken.X) + Math.abs(home.Y - chicken.Y);
            }
        }

        dfs(-1, new ArrayList<>(), M);

        System.out.println(result);
        
    }
    static void dfs(int index, List<Integer> indexArr, int M){
        if(indexArr.size() == M){
            //  도시의 치킨 거리
            int tmpResult = 0;
            for(int y = 0; y < distance.length; y++){
                // 페업하지 않은 치킨집 중 가장 가까운 거리
                int minHomeDistance = Integer.MAX_VALUE;
                for(int x : indexArr){
                    minHomeDistance = Math.min(minHomeDistance, distance[y][x]);
                }
                tmpResult += minHomeDistance;
            }
            result = Math.min(result, tmpResult);
            return;
        }

        for(int i = index + 1; i < chickens.size(); i++){
            indexArr.add(i);
            dfs(i, indexArr, M);
            indexArr.remove(indexArr.size() - 1);
        }

    }

    static class YX{
        int Y;
        int X;

        public YX(int y, int x) {
            Y = y;
            X = x;
        }
    }
}
