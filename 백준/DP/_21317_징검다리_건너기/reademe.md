# 징검다리 건너기

- https://www.acmicpc.net/problem/21317

## 해설

재귀 bottom up

- 깊이로 탐색하면서 리프노드에 도달 하였을 때 더한 값들을 return
- 각 리프에서의 합들 중 가장 작은 값을 출력
- superjump(2칸 뛰기)는 boolean메서드로 딱 한번만 사용할 수 있게 끔 제작.
- 보통 dp 사용하면 리프노드 찍고 하나하나 만들어가는 방식. but, 여기서는 계속 실패하고 잘 안됨.함.