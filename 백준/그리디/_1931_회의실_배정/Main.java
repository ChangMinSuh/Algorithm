package 백준.그리디._1931_회의실_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

/*
그리디, 정렬

가장 빨리 끝나는 회의 부터 최적을 찾아가면 된다.
2차원 배열 사용.
    - metting[][0] 은 start, metting[][1] 은 end.
    - end를 오름차순으로 정렬한다. 같을 경우에는 start를 오름차순으로.
정렬된 배열로 for문 시작
    - 현재 start가 마지막으로 나온 end 보다 작은 경우에는 겹쳐서 회의 불가능.
    - 회의가 가능할 경우에는 result + 1, 마지막으로 나온 end 업데이트
주의
    (1,1), (0, 5) 인 경우도 고려.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int N = Integer.parseInt(br.readLine());
        int mettings[][] = new int[N][2];

        // map 제작.
        for(int i = 0; i < N; i++){
            String input[] = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            mettings[i][0] = start;
            mettings[i][1] = end;
        }

        Arrays.sort(mettings, (o1, o2) ->
                o1[1] == o2[1]
                ? o1[0] - o2[0]
                : o1[1] - o2[1]
        );

        int result = 0;
        int lastEnd = 0; // 가장 빨리 끝난 회의

        // solve
        for(int i = 0; i < N; i++){
            if(mettings[i][0] < lastEnd ) continue;
            result++;
            lastEnd = mettings[i][1];
        }

        System.out.println(result);
    }
}
