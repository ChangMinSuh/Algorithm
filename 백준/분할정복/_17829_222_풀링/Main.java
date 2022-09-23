package 백준.분할정복._17829_222_풀링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
분할정복

- 분할정복을 통해 2X2가 될 때 까지 분할
    - 2 X 2 라면, 따로 리스트를 만들어 정렬 후, 2번째로 큰 값을 반환.
    - 반환 된 값을 토대로 배열 arr을 초기화 시켜줌.
- 위 과정을 arr이 2 X 2가 될 때 까지 반복.
- arr[0][0]이 정답
 */

public class Main {
    static int[][] arr;
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

        do{
            arr = func(0, 0, N, N, new int[N][N]);
        } while((N /= 2) > 1); // N이 2일때 까지 반복문

        System.out.println(arr[0][0]);
    }

    private static int[][] func(int startY, int startX, int endY, int endX, int[][] result){
        if(startY + 2 == endY){
            List<Integer> list = new ArrayList<>();
            list.add(arr[startY][startX]);
            list.add(arr[startY][startX + 1]);
            list.add(arr[startY + 1][startX]);
            list.add(arr[startY + 1][startX + 1]);

            // 오름차순이므로 list[2]가 2번쨰로 큰 값
            list.sort(((o1, o2) -> o1 - o2));

            result[startY / 2][startX / 2] = list.get(2);
            return result;
        }

        int midY = (startY + endY) / 2;
        int midX = (startX + endX) / 2;

        func(startY, startX, midY, midX, result);
        func(midY, startX, endY, midX, result);
        func(startY, midX, midY, endX, result);
        func(midY, midX, endY, endX, result);

        return result;
    }
}
