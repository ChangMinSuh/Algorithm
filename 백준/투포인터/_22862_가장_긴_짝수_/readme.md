# 가장 긴 짝수

- https://www.acmicpc.net/problem/22862

## 해설
투포인트

- 투포인트를 사용하여 연속된 모든 경우를 체크한다.
- 짝수
- 짝수 개수 + 1, enㅇ + 1
- 홀수 =>
- K보다 작다면
  - end + 1, 홀수개수 + 1
- K보다 크다면
  - 홀수가 나올떄까지 start + 1, 짝수개수 - 1
  - 홀수가 나오면 end++.