# 외판원 순회 2

- https://www.acmicpc.net/problem/10971

## 해설

백 트래킹

- dfs를 통해 모든 경우를 다 구해 최소값을 출력.
  - index 1부터 출발한다고 가정
  - 2 ~ N까지 모든 경우를 탐색.
    - 깊이 탐색할 때 마다 cnt + 1, result + 거리비용(cost), visited[i] = true 해줌.
  - cnt N -1이 된다면(1빼고 다 돌았다면, 기저 조건)
    - 1로 돌아오는 경우까지 더해준 후, 기존 result와 비교.