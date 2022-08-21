package 백준.그래프탐색._1260_DFS와_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        // init
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // graph init
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // graph sort
        for(int i = 1; i <= N; i++) graph.get(i).sort((o1, o2) -> o1 - o2);

        dfs(V);
        sb.append("\n");

        Arrays.fill(visited, false);

        bfs(V);

        System.out.println(sb);
    }
   static void dfs(int vertex){
        visited[vertex] = true;
        sb.append(vertex).append(" ");

        List<Integer> list = graph.get(vertex);
        for(int nextVertex: list){
            if(visited[nextVertex]) continue;
            dfs(nextVertex);
        }
    }

    static void bfs(int vertex){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(vertex);
        visited[vertex] = true;

        while(!qu.isEmpty()){
            int nowVertex = qu.poll();
            sb.append(nowVertex).append(" ");

            List<Integer> list = graph.get(nowVertex);
            for(int nextVertex: list){
                if(visited[nextVertex]) continue;
                visited[nextVertex] = true;
                qu.add(nextVertex);
            }
        }
    }

}
