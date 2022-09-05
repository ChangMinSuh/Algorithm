package 백준.시물레이션._5212_지구_온난화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시물레이션

- 모든 지도를 돌면서 섬(X)이면 주위에 바다(.)인지 확인
    - 3,4개라면 #으로 바꿔줌.
        - 미래의 바다는 섬에 영향을 주면 안되므로 다른 문자로 치환.
    - 장외 또한 바다임.
- 2중 for문을 통해 출력할 지도 가로세로 위치 구함.
- 출력
    - #은 미래의 바다이므로 .으로 바꿔서 출력


 */
public class Main {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        // 출력될 지도 범위
        int[] resultR = {R, 0};
        int[] resultC = {C, 0};
        char[][] arr = new char[R][C];

        for(int r = 0; r < R; r++){
            String line = br.readLine();
            for(int c = 0; c < C; c++){
                arr[r][c] = line.charAt(c);
            }
        }

        // 땅 잠김 시물레이션
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(arr[r][c] != 'X') continue;
                int cnt = 0;
                for(int i = 0; i < 4; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    // 바다가 아니라면 넘김.
                    if(0 <= nr && 0 <= nc && nr < R && nc < C
                            && arr[nr][nc] != '.')  continue;

                    // 장외 또한 바다임.
                    cnt++;
                }
                if(3 <= cnt) {
                    arr[r][c] ='#'; // 미래의 바다. 과거의 바다와 구분.
                }
            }
        }

        // 출력할 지도 크기 만들기
        for(int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(arr[r][c] == 'X'){
                    resultR[0] = Math.min(resultR[0], r);
                    resultR[1] = Math.max(resultR[1], r);
                    resultC[0] = Math.min(resultC[0], c);
                    resultC[1] = Math.max(resultC[1], c);
                }
            }
        }


        for(int r = resultR[0]; r <= resultR[1]; r++) {
            for (int c = resultC[0]; c <= resultC[1]; c++) {
                // # 은 미래으 바다이므로 .으로 바꿔서 출력
                sb.append(arr[r][c] == '#' ? '.' : arr[r][c]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
