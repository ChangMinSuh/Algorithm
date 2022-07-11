// 문제 : 아래와 같이 출력 되도록 해주세요.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// dfs

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        int[] parents = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());



        for(int i = 0; i < N - 1; i++){
            String line = bf.readLine();
            String inputArr[] = line.split(" ",2);
            int n1 = Integer.parseInt(inputArr[0]);
            int n2 = Integer.parseInt(inputArr[1]);

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        parents[1] = 987654321; // root의 부모는 없으므로 미리 지정.
        dfs(graph, parents, 1);

        for(int i = 2; i <= N; i++) sb.append(parents[i] + "\n");
        System.out.println(sb);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph,int [] parents ,int parent){
        for(int child : graph.get(parent) ){
            if(parents[child] == 0){ // 부모를 찾아보지 못한곳으로 탐색해야함.
                parents[child] = parent;
                dfs(graph, parents, child);
            }
        }
    }
}

