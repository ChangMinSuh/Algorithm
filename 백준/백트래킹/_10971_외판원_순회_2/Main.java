package 백준.백트래킹._10971_외판원_순회_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백 트래킹

- dfs를 통해 모든 경우를 다 구해 최소값을 출력.
    - index 1부터 출발한다고 가정
    - 2 ~ N까지 모든 경우를 탐색.
        - 깊이 탐색할 때 마다 cnt + 1, result + 거리비용(cost), visited[i] = true 해줌.
    - cnt N -1이 된다면(1빼고 다 돌았다면, 기저 조건)
        - 1로 돌아오는 경우까지 더해준 후, 기존 result와 비교.
 */

public class Main {
    static int[][] arr;
    static int N;
    static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
         arr = new int[N + 1][N + 1];
        for(int y = 1; y <= N ;y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= N; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, new boolean[N + 1], 0, 0);
        System.out.println(minResult);
    }

    static void dfs(int now, boolean[] visited, int cnt, int result){
        // 기저 조건
        // 처음빼고 다 돌았다면, 마지막 돌아오는 길을 여기서 더해줌.
        if(cnt + 1 == N){
            // result에 다시 돌아오는 것(arr[now][1]) 까지 더함
            int lastCost = arr[now][1];
            if(lastCost == 0) return;
            // minResult와 비교해 더 작은 것으로 초기화
            minResult = Math.min(minResult, result + lastCost);
            return;
        }

        // 1부터 시작한다고 가정하고 1을 제외한 모든 곳을 탐색함.
        for(int i = 2; i <= N ; i++){
            int cost = arr[now][i];
            if(cost == 0 || visited[i]) continue;

            visited[i] = true;
            dfs(i, visited, cnt + 1 , result + cost);
            visited[i] = false;
        }
    }
}
