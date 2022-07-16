package 백준.그리디._2141_우체국;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
??그리디??

사람 수 중 가장 중간값을 가져오면 된다.
수학적 증명이 필요한듯 하나 잘 모르겠음.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] X = new int[N][2]; // 마을 위치, 사람 수
        //TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        long peopleSum = 0;

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            X[i][0]= Integer.parseInt(input[0]);
            X[i][1] = Integer.parseInt(input[1]);
            peopleSum += X[i][1];
        }

        Arrays.sort(X, (o1, o2) -> o1[0] - o2[0]);

        long mid = (long)Math.ceil((double) peopleSum / 2);
        long peopleCnt = 0;

        for(int i = 0; i < N; i++){
            peopleCnt += X[i][1];
            if(peopleCnt < mid) continue;
            System.out.println(X[i][0]);
            return;
        }
        System.out.println(X[N - 1][0]);
    }
}
