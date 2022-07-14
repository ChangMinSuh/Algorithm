package 백준.트리._5639_이진_검색_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    이진탐색? dfs

    root가 정해저 있으니 이분탐색 사용해서 트리 만들고 후위순위 하면됨.
    index 1부터 값이 저장되어있음.
 */

class Main {
    public static void main(String[] args) throws IOException {
        final int START_INDEX = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";

        ArrayList<Integer> inputArr = new ArrayList<>(); // data
        int [][] tree = new int[10005][2];              // tree

        inputArr.add(0); // 인덱스 0을 비우기 위해 추가.

        while((input= br.readLine()) != null){ // EOF
            inputArr.add(Integer.parseInt(input));
        }

        // 트리를 만들어 가는 과정.
        for(int newIndex = 2; newIndex < inputArr.size() ; newIndex++){ // root는 하면 안됨.
            int connectIndex = START_INDEX; // 진입한 현재 노드.
            while(true){
                // 새로운 노드 값 < 부모 노드 값 (왼쪽 자식 노드)
                if(inputArr.get(newIndex) < inputArr.get(connectIndex)) {
                    if(tree[connectIndex][0] == 0){
                        tree[connectIndex][0] = newIndex;
                        break;
                    }
                        connectIndex = tree[connectIndex][0];
                }
                // 새로운 노드 값 > 부모 노드 값 (오른쪽 자식 노드)
                else{
                    if(tree[connectIndex][1] == 0){
                        tree[connectIndex][1] = newIndex;
                        break;
                    }
                    connectIndex = tree[connectIndex][1];
                }
            }
        }
        posFunc(tree, inputArr, sb, START_INDEX);

        System.out.println(sb);

    }

    static void posFunc(int[][] tree,ArrayList<Integer> inputArr, StringBuilder sb, int now) {
        if(now < 1) return;
        posFunc(tree, inputArr, sb, tree[now][0]);
        posFunc(tree, inputArr, sb, tree[now][1]);
        sb.append(inputArr.get(now )+ "\n");
    }

}