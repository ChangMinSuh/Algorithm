# 귀찮아

- https://www.acmicpc.net/problem/14929

## 해설

누적합

- 배열의 누적합을 우선 구한다.
- a1 * a2 + a1 * a3 + a2 * a3
  => a1(a2 + a3) + a2(a3)
  => result += arr[i] * (sum[N] - sum[i]);