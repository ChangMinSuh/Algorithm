package 백준.완전탐색._16439_치킨치킨치킨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
완전탐색

- 치킨 경우의 수 = M C 3 => O(M ^ 3)
    - 치킨종류 30개이기 때문에 충분히 가능
- 모든 사용자 선호도 조사 = N
- 전체 => O(N * M ^ 3)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        // 치킨이 모두 다른 경우만 검사
        for(int i = 0; i < M; i++){
            for(int j = i + 1; j < M; j++){
                for(int k = j + 1; k < M; k++){
                    int sum = 0;
                    // 모든 사람의 최대 만족도 조사.
                    for(int mem = 0; mem < N; mem++){
                        // 3개의 치킨중 가장 만족도 높은 값 더함.
                         sum += Math.max(Math.max(arr[mem][i],arr[mem][j]), arr[mem][k]);
                    }
                    if(result < sum) result = sum;
                }
            }
        }
        System.out.println(result);
    }
}
