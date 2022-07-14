# N번째 큰 수

- https://www.acmicpc.net/problem/2075

## 해설

우선순위 큐

- 전체를 우선순위 큐에 넣으면
  - N = 1500 * 1500, 시간복잡도 = **O(NlogN)** => 1500*1500\*1500 = 30억.
  - 우선순위 큐 만드는데만 **10억 넘어서 1초 초과**
- 열에서 가장 큰 값들만(맨 밑에있는 값들) 우선순위 큐, 나머지 수들은 2차원 배열에 삽입.
- 우선순위 큐에서 값이 출력되면, 그 값이 머물렀던 열의 가장 큰 값(가장 뒤에있는 값)을 우선순위 큐에 삽입.

- 우선순위 큐에 삽입한 데이터(stack[]을 직접 못만들어서 제작.)

  ```java
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
  ```
