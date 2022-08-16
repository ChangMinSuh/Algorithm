package 백준.구현._16926_배열_돌리기_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
구현

- 큰 테두리부터 작은 테두리까지 각각 계산한다
    - 하나의 테두리를 newR만큼 돌리기를 한다.
        - R은 아무리 커봐야 테두리 크기 안이므로 테두리 길이로 나눠 나머지를 적용.(newR)
    - 첫 노드를 newR만큼 돌리고, 나머지는 그 전 노드에 맞춰서 하나씩 이동한다.

 */

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        result = new int[N][M];
        for(int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 큰 테두리부터 작은 테두리까지 각각 계산한다
        // R은 아무리 커봐야 테두리 크기 안이므로 테두리 길이로 나눠 나머지를 적용.
        int startY = 0, startX = 0;
        int endY = N - 1, endX = M - 1;
        while(startY < N / 2 && startX < M / 2){
            // newR을 만든다.
            int newR = R % (2 * (endY - startY + endX - startX));

            // 하나의 테두리를 newR만큼 이동시킨다.
            func(startY, startX, endY, endX, newR);

            // 작은 테두리로 만든다.
            startY++; startX++;
            endY--; endX--;
        }

        // print
        for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                sb.append(result[y][x]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    // 하나의 테두리를 newR만큼 돌리기를 한다.
    static void func (int startY, int startX, int endY, int endX,int newR){
        int resultY = startY, arrY = startY;
        int resultX = startX, arrX = startX;

        //  처음 설정.
        // newR번 만큼 이동.
        for(int i = 0; i < newR; i++){
            // result 이동
            if(resultX == startX && resultY < endY) resultY++;
            else if(resultX < endX && resultY == endY) resultX++;
            else if(resultX == endX && resultY > startX) resultY--;
            else resultX--;
        }

        result[resultY][resultX] = arr[arrY][arrX];

        // arr 이동
        arrY++;


        // 나머지는 그 전 노드에 맞춰 이동
        while(arrY != startY || arrX != startX){
            // result 이동
            if(resultX == startX && resultY < endY) resultY++;
            else if(resultX < endX && resultY == endY) resultX++;
            else if(resultX == endX && resultY > startY) resultY--;
            else resultX--;

            result[resultY][resultX] = arr[arrY][arrX];

            // arr 이동
            if(arrX == startX && arrY < endY) arrY++;
            else if(arrX < endX && arrY == endY) arrX++;
            else if(arrX == endX && arrY > startY) arrY--;
            else arrX--;
        }
    }
}
