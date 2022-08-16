package 백준.구현._2615_오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
구현

- 모든 부분에서 오목이 나올 수 있는지 8방향으로 검사한다.
    - static int[] my = {-1, 0, 1, 1, 1, 0, -1, -1};
    - static int[] mx = {1, 1, 1, 0, -1, -1, -1, 0};
    - 0 ~ 3까지는 출발점.
    - 4 ~ 7까진 도착점이 정답!

- 육목 검사 해야한다. 앞과 뒤로 꼭 해줘야한다.

 */

public class Main {
    static int[] my = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] mx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[][] board = new int[20][20];
    public static void main(String[] args) throws IOException {

        final int BOARD_LINE = 19;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        for(int i = 0; i < BOARD_LINE; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < BOARD_LINE; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y = 0; y < BOARD_LINE; y++){
            for(int x = 0; x < BOARD_LINE; x++){
                if(board[y][x] == 0) continue;

                // 모든 방향 검사
                for(int i = 0; i < 8; i++){
                    boolean isSuccess = true;
                    int ny = 0, nx = 0;

                    // 오목인지 확인
                    for(int j = 1; j <= 4; j++) {
                        ny = y + my[i] * j;
                        nx = x + mx[i] * j;
                        // 그 다음이 0이거나 장외일 경우.
                        if(ny < 0 || nx < 0 || ny > BOARD_LINE || nx > BOARD_LINE
                        || board[y][x] != board[ny][nx]
                        ){
                            isSuccess = false; break;
                        }
                    }

                    // 실패했거나,  육목이 아닌 경우(앞,뒤로 체크)
                    if(
                        !isSuccess

                        || 0 <= ny + my[i] && ny + my[i] < BOARD_LINE
                        && 0 <= nx + mx[i] && nx + mx[i] < BOARD_LINE
                        && board[y][x] == board[ny + my[i]][nx + mx[i]]

                        || 0 <= y - my[i] && y - my[i] < BOARD_LINE
                        && 0 <= x - mx[i] && x - mx[i] < BOARD_LINE
                        && board[y - my[i]][x - mx[i]] == board[ny][nx]
                    ) continue;

                    // 성공했을 경우,
                    System.out.println(board[y][x]);
                    // 0 ~ 3까지는 x와 y.
                    // 4 ~ 7까진 nx와 ny.
                    System.out.println(
                            i < 4
                                    ? (y + 1) + " " + (x + 1)
                                    : (ny + 1) + " " + (nx + 1)
                    );
                    return;

                }
            }
        }
        System.out.println(0);
    }
}
