package 백준.분할정복._2630_색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
분활정복

- 4등분으로 나눠 분활
    - 분활된 면이 다 같은 색이라면 해당 색 + 1.
 */

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int y = 0; y < N; y++){
            st= new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        func(0,0,N,N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void func(int startY, int startX, int endY, int endX){
        // 왼쪽 위 색족이 색.
        int color = arr[startY][startX];
        boolean isAllSame = isAllSame(startY, startX, endY, endX);

        if(isAllSame) {
            if(color == 0) white++;
            else blue++;
            return;
        }

        int midY = (startY + endY) / 2;
        int midX = (startX + endX) / 2;
        // 1,2,3,4 사분면으로 검사(순서 X)
        func(startY,startX,midY,midX);
        func(startY,midX,midY,endX);
        func(midY,startX,endY,midX);
        func(midY,midX,endY,endX);
    }

    private static boolean isAllSame(int startY, int startX, int endY, int endX){
        int color = arr[startY][startX];
        for(int y = startY; y < endY; y++){
            for(int x = startX; x < endX; x++){
                if(arr[y][x] != color){
                    return false;
                }
            }
        }
        return true;
    }

}
