import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
전체를 우선순위 큐에 넣으면
N = 1500 * 1500, 시간복잡도 = O(NlogN) => 1500*1500*1500 = 30억.
우선순위 큐 만드는데만 10억 넘어서 1초 초과
가장 큰 값들만 우선순위 큐, 나머지 수들은 2차원 배열에 삽입.
우선순위 큐에서 값이 출력되면, 그 값이 머물렀던 열의 가장 큰 값(가장 뒤에있는 값)을 우선순위 큐에 삽입.
*/


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<PqData> pq = new PriorityQueue<PqData>(((o1, o2) -> o2.getData() - o1.getData()));
        // stack[] 대신 구현
        int allNum[][] = new int[N][N];
        int topRowAllNum[] = new int[N]; // 현재 allNum의 행의 값을 나타냄.
        Arrays.fill(topRowAllNum, N - 2); // 가장 큰 값 제외.


        for(int i = 0; i < N - 1; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " "); // split과 비슷한 역할
            int indexCnt = 0;
            while(st.hasMoreTokens()){
                allNum[i][indexCnt++] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 큰 수는 우선순위 큐에 삽입.
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int indexCnt = 0;
        while(st.hasMoreTokens()){
            pq.add(new PqData(Integer.parseInt(st.nextToken()), indexCnt++));
        }

        // 큰수부터 N + 1번째 수까지 반복문 실행.
        while(N-- > 1){
            PqData pqData = pq.remove();
            // numArr의 행
            int column = pqData.getNumArrColumnIndex(); // 열
            int row = topRowAllNum[column]; // 행
            // allNum에 해당하는 값과, allNum의 열 인덱스값을 pg에 삽입.
            pq.add(new PqData(allNum[row][column], column));
            // allNum의 현재 행 인덱스 값을 하나 낮춤.
            topRowAllNum[column]--;
        }

        PqData pqData = pq.remove();

        System.out.println(pqData.getData());
    }
}

class PqData{
    private int data; // 값
    private int numArrColumnIndex; // 2차 배열의 열 인덱스
    public PqData(int data,int numArrColumnIndex){
        this.data = data;
        this.numArrColumnIndex = numArrColumnIndex;
    }

    public int getData() {
        return data;
    }

    public int getNumArrColumnIndex() {
        return numArrColumnIndex;
    }
}