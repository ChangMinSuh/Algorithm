
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
n진트리 dfs

자식 노드와의 관계를 나타내는 Tree 배열 선언.
Tree 배열에는 루트와 지워야하는 노드의 정보를 저장하지 않음.
탐색으로 루프노드일때 return 값 +1함.
이떄, 루프 노드는 노드의 차수가 0인것으로 구분할 수 있음.

 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        int rootIndex = 0; // root
        ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        int [] inputArr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int deleteNodeIndex = Integer.parseInt(bf.readLine());

        for(int i = 0; i < N; i++) { // 트리 제작
            if (inputArr[i] == -1) {
                rootIndex = i;
                continue;
            }
            if(i == deleteNodeIndex) continue;
            tree.get(inputArr[i]).add(i);
        }

        int result = rootIndex == deleteNodeIndex
                ? 0
                :dfs(tree, deleteNodeIndex, rootIndex);
        System.out.println(result);
    }

    static int dfs(ArrayList<ArrayList<Integer>> tree, int deleteNodeIndex, int now){
        int sum = 0;
        if(tree.get(now).isEmpty()) return 1; // 리프노트(자식 노드가 비어있음)

        for(int child :tree.get(now)){
            sum += dfs(tree,deleteNodeIndex,child);
        }
        return sum;
    }
}