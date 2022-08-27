package 백준.완전탐색._14500_테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
구현, 완탐.

- 나올 수 있는 모든 도형의 모양을 구한 후, 한칸 한칸씩 대입해 최대치를 구한다.
    - 2, 1, 8, 4, 4
- 계속 틀리다면 반례한번 테스트 해보기
    - https://www.acmicpc.net/board/view/61597
 */

public class Main {
    static int[][][] tetrominos = { // {y, x}
        // 1
                {{0,0}, {0,1}, {0,2}, {0,3}},
                {{0,0}, {1,0}, {2,0}, {3,0}},

        // 2
                {{0,0}, {1,0}, {0,1}, {1,1}},
        // 3
                {{0,0}, {1,0}, {2,0}, {2,1}},
                {{0,0}, {1,0}, {2,0}, {2,-1}},
                {{0,0}, {1,0}, {2,0}, {0,1}},
                {{0,0}, {1,0}, {2,0}, {0,-1}},
                {{0,0}, {1,0}, {0,1}, {0, 2}},
                {{0,0}, {1,0}, {0,-1}, {0, -2}},
                {{0,0}, {1,0}, {1,1}, {1, 2}},
                {{0,0}, {1,0}, {1,-1}, {1, -2}},
        // 4
                {{0,0}, {1,0}, {1,1}, {2,1}},
                {{0,0}, {1,0}, {1,-1}, {2,-1}},
                {{0,0}, {0,1}, {1,1}, {1,2}},
                {{0,0}, {0,1}, {-1,1}, {-1,2}},
        // 5
                {{0,0}, {0,1}, {0,2}, {1,1}},
                {{0,0}, {0,1}, {0,2}, {-1,1}},
                {{0,0}, {1,0}, {2,0}, {1, 1}},
                {{0,0}, {1,0}, {2,0}, {1, -1}}

    };
    public static void main(String[] args) throws IOException {
        // init
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

        // 구현
        for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                // 해당 y, x에 도형 모두 대입해보기
               for(int[][] tetromino: tetrominos){
                   int sumTetromino = 0; // 새로운 테크노미노의 값
                   boolean isSuccess = true; // 테크노미노가 장외인지
                   int[][] newTetromino = new int[4][2]; // 새로운 테크노미노
                   for(int i = 0; i < 4; i++){
                       newTetromino[i][0] = tetromino[i][0] + y;
                       newTetromino[i][1] = tetromino[i][1] + x;
                       // 장외라면 멈춤.
                       if(newTetromino[i][0] < 0
                       || newTetromino[i][1] < 0
                       || N <= newTetromino[i][0]
                       || M <= newTetromino[i][1]) {
                           isSuccess = false;
                           break;
                       }
                       // 해당 테크로미노 값을 구함.
                       sumTetromino += arr[newTetromino[i][0]][newTetromino[i][1]];
                   }
                   // 장외라면 다음 테트로미노로 넘어감.
                   if(!isSuccess) continue;
                   result = Math.max(result, sumTetromino);
               }
            }
        }
        System.out.println(result);
    }
}
