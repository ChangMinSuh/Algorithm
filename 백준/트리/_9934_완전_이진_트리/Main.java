package 백준.트리._9934_완전_이진_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    bfs

    이진트리이며,그중에서도 포화 이진트리. (2^N - 1) 이기 떄문.
    배열의 가운데 값이 나머지 노드들의 조상노드!
    분할 정복 처럼 중앙값을 캐치. 나눠진 두 부분의 중앙값을 또 캐치
    트리의 레벨을 구분하기 위해 bfs의 큐 사이즈 도입
    자식노드만큼 큐에 push 되기 떄문.

 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(bf.readLine());
        int[] inputArr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        bfs(inputArr, sb, 0, inputArr.length - 1);
        System.out.println(sb);
    }

    static void bfs(int[] inputArr, StringBuilder sb , int start, int end){
        Queue<BfsData> qu = new LinkedList();

        qu.add(new BfsData(start, end));

        while(!qu.isEmpty()){
            int quSize = qu.size(); // 레벨을 구분하기 위해서
            while(quSize-- > 0){
                BfsData quPop = qu.remove();
                start = quPop.getStart();
                end = quPop.getEnd();
                if(end < start) break;

                int mid = (start + end) / 2;
                sb.append(inputArr[mid] + " ");

                qu.add(new BfsData(start, mid - 1));
                qu.add(new BfsData(mid + 1, end));
            }
            sb.append('\n');
        }
    }
}

class BfsData{
    private int start;
    private int end;
    BfsData(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
