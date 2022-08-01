# 주짓수

- https://www.acmicpc.net/problem/15724

## 해설
dp

- memo를 먼저 다 구함
    - 인덱스를 1부터 시작하게 설계.
    - memo[i][j] = memo[i-1][j] + memo[i][j - 1] - memo[i - 1][j - 1] + arr[i][j]
    - 중복되는 곳 제거 필수

- 전체 합 구하는법
    - memo[x2][y2] - memo[x1 -1][y2] - memo[x2][y1 - 1] + memo[x1 - 1][y1 - 1]
    - 중복되는 곳 제거 필수
- string tokener가 시간이 확 줄긴 하는듯