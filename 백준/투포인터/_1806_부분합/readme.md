# 부분합

- https://www.acmicpc.net/problem/1806

## 해설

투포인터

- 우선 한자리(arr[end])를 sum에 더한다.
- 연속된 부분합이 최소 합(S)를 넘기면 최소 합(S)보다 작아질 때 까지 start + 1, result 업데이트.
- 나머지는 end + 1.
- 주의
    - 값이 없을 때 0 출력 주의