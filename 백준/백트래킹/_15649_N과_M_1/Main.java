package 백준.백트래킹._15649_N과_M_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*
백 트래킹

- dfs에 result, visited 배열을 사용하여 중복되지 않는 수열의 경우의 수를 모두 구해준다.

- result의 크기가 M과 같다면 기저 조건으로 result에 있는 값 모두 출력


 */

public class Main {
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0, new ArrayList<>(), new boolean[N + 1]);
        System.out.println(sb);
    }

    private static void dfs(int now, List<Integer> result, boolean[] visited){
        // 기저 조건
        // now가 끝까지 갔을 떄
        if(result.size() == M){
            for(int num :result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;

            result.add(i); visited[i] = true;
            dfs(i, result, visited);
            result.remove(result.size() - 1); visited[i] = false;
        }
    }
}
