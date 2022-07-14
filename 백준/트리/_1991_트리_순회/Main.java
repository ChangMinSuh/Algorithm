package 백준.트리._1991_트리_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    트리, 재귀

 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        int  N = Integer.parseInt(bf.readLine());
        int tree[][] = new int[N][2];

        while(N-- > 0){ // 2차원 배열로 트리 제작
            char[] inputArr = bf.readLine().toCharArray();

            tree[inputArr[0] - 'A'][0] = inputArr[2] == '.'
                    ? -1
                    : inputArr[2] - 'A';
            tree[inputArr[0] - 'A'][1] = inputArr[4] == '.'
                    ? -1
                    :inputArr[4] - 'A';
        }
        preFunc(tree, 0); System.out.print('\n');
        infFunc(tree, 0); System.out.print('\n');
        posFunc(tree, 0);
    }

    static void preFunc(int[][] tree,int now){
        if (now < 0) return;
        System.out.print((char) (now + 'A'));
        preFunc(tree, tree[now][0]);
        preFunc(tree, tree[now][1]);
    }
    static void infFunc(int[][] tree,int now){
        if (now < 0) return;
        infFunc(tree, tree[now][0]);
        System.out.print((char) (now + 'A'));
        infFunc(tree, tree[now][1]);
    }
    static void posFunc(int[][] tree,int now){
        if (now < 0) return;
        posFunc(tree, tree[now][0]);
        posFunc(tree, tree[now][1]);
        System.out.print((char) (now + 'A'));
    }
}
