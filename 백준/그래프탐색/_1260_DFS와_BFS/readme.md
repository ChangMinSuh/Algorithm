# DFS와 BFS

- https://www.acmicpc.net/problem/1260

## 해설
bfs

- 처음에 dfs로 접근했지만, 시간초과. dp를 사용해야 할 것 같다.

- 두번쨰에 bfs 사용
  - 3차원 배열 만들어 이동 경로 bfs에 따라 증가시키며 저장
  - 벽은 1 => -1로 저장
  - arr[0][][]에는 하나도 벽을 뚫지 못했을 경우 저장
  - arr[1][][]에는 하나의 벽을 뚫었을 때 저장.
  - bfs로 한칸한칸 늘어나기 때문에 시간이 오바되어 겹치는 일은 없을 것 같다.
.