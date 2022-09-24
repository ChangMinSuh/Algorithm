package 백준.분할정복._2448_별찍기_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
분할 정복

- 3개의 구간으로 분활한다
    - 맨위 중간, 왼쪽아래, 오른쪽 아래
- 세모를 넣을 수 있는 최소한의 직사각형을 영역이라 가정
    - 직사각형의 왼쪽 위의 자표를 인자로 처리.
    - 직사각형의 가로의 길이가 N * 2 이므로, N에 2를 미리 곱함.

- 분할 정복 후 N이 6이 될 때, 지정된 위치에 별 표시.
 */

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        // 가로의 길이가 N * 2라 미리 곱해준다.
        N *= 2;
        arr = new char[N][N * 2];
        func(0,0, N);

        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++) sb.append(arr[y][x] == '*' ? '*' : ' ');
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void func(int startY, int startX, int N){
        if(N == 6){ // 최대한으로 분할했을 시.
            int[] dy = {0, 1, 1, 2, 2, 2, 2, 2};
            int[] dx = {2, 1, 3, 0, 1, 2, 3, 4};

            for(int i = 0; i < 8; i++){
                int ny = startY + dy[i];
                int nx = startX + dx[i];
                arr[ny][nx] = '*';
            }
            return;
        }

        int moveY = N / 4; // 기존 Y의 길이는 N / 2. 길이의 1/ 2
        int moveX = N / 4; // 기존 X의 길이는 N. 길이의 1 / 4 만큼 이동

        func(startY, startX + moveX, N / 2); // 맨 위
        func(startY + moveY, startX, N / 2); // 왼쪽 아래
        func(startY + moveY, startX + N / 2, N / 2); // 오른쪽 아래
    }
}
