# LCS

- https://www.acmicpc.net/problem/9251

## 해설
LCS, 2차원 dp

- 2차원 dp 이용
- for문으로 2차원 배열을 행렬 순서대로 탐색
    - 작은 부분배열에서 큰 부분배열로 넘어감
        - (C, A) => (C, AC) -> ...-> (CA, A) -> ... -> (CAPCAK, ACAYKP)
    - memo의 위 vs 왼쪽 중 가장 큰 값을 저장
        - 현재 memo는 전의 memo를 이어 받기 때문.
        - memo[y][x] = Math.max(memo[y][x - 1], memo[y - 1][x]);
    - 만약 현재 인덱스의 문자가 같다면, 저장된 값 vs 왼쪽 위 + 1중 큰값.
        - memo[y][x] = Math.max(memo[y][x], memo[y-1][x-1] + 1)
