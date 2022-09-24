package 백준.분할정복._2447_별찍기_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
분할 정복

-  3 X 3으로 분활 한다. 단 (1, 1)은 포함 X
- 길이가 3까지 갔을 때 (1, 1)을 제외한 장소에 '*'을 추가해준다.
 */

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        func(0,0, N);

        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++) sb.append(arr[y][x] == '*' ? '*' : ' ');
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void func(int startY, int startX, int N){
        if(N == 3){ // 최대한으로 분할했을 시.
            for(int i = 0; i < 3; i++) arr[startY][startX + i] = '*';
            arr[startY + 1][startX] = arr[startY + 1][startX + 2] = '*';
            for(int i = 0; i < 3; i++) arr[startY + 2][startX + i] = '*';
            return;
        }

        int nextN = N / 3;

        // 가운데 제외하고 분할
        for(int i = 0; i < 3; i++) func(startY, startX + nextN * i, nextN);
        func(startY + nextN, startX, nextN);
        func(startY + nextN, startX + nextN * 2, nextN);
        for(int i = 0; i < 3; i++) func(startY + nextN * 2, startX + nextN * i, nextN);
    }
}
