# 동전 1

- https://www.acmicpc.net/problem/2293

## 해설
2차원dp

- 동전을 큰 순서로 정렬 후, 차레대로 탐색 시작
- 동전은 자신보다 작은 동전을 탐색할 수 없다.
- 각 동전별로 memo 제작.

ex)
3,2,1
1. 3
2. 3, 2
3. 3, 2, 1
   