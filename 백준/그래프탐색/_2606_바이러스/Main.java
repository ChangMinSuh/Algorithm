package 백준.그래프탐색._2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
dfs

- ArrayList 2차원 사용하여 그래프 구현.
- 1을 시작으로 dfs를 순회하며 만난 node만큼 반환.
 */

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
             st = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());

            // graph 설계
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int result = dfs(1);
        System.out.println(result);

    }

    public static int dfs(int vertex){
        int result = 0;
        visited[vertex] = true;

        List<Integer> list = graph.get(vertex);
        for(int nextVertex: list){
            if(visited[nextVertex]) continue;
            // 방문하지 않은 곳이니 + 1 해준다.
            result += dfs(nextVertex) + 1;
        }
        return result;
    }
}
