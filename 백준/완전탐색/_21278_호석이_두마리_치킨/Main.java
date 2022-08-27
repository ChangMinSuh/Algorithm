package 백준.완전탐색._21278_호석이_두마리_치킨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
플로이드 워셜

- 플로이드 워셜로 모든 경로의 도달 거리(가중치)를 구한다.
    - graph
    - O(N ^3)
- graph를 이용해 왕복가능 경우를 모두 탐색하여 가장 시간이 적은 값을 출력.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N + 1][N + 1]; // 도달 거리(가중치)를 저장.

        // 0인 부분을 최대치(200)로 채움.
        for(int i = 0; i < N + 1; i++)
            Arrays.fill(graph[i], 200);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph[y][x] = graph[x][y] = 1;
        }

        // 플로이드 워셜
        for(int k = 1; k <= N; k++) {
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    graph[y][x] = Math.min(graph[y][x], graph[k][y] + graph[k][x]);
                }
            }
        }

        int resultNode1 = 0;
        int resultNode2 = 0;
        int resultDistance = Integer.MAX_VALUE;

        for (int node1 = 1; node1 <= N; node1++) {
            for (int node2 = node1 + 1; node2 <= N; node2++) {
                //왕복 거리 합 구하기.
                int tmpDistance = 0;
                for(int i = 1; i <= N; i++){
                    if(i == node1 || i == node2) continue;
                    tmpDistance += Math.min(graph[node1][i], graph[node2][i]);
                }
                if(tmpDistance < resultDistance){
                    resultNode1 = node1;
                    resultNode2 = node2;
                    resultDistance = tmpDistance;
                }
            }
        }


        System.out.printf("%d %d %d", resultNode1, resultNode2, resultDistance * 2);
    }
}
