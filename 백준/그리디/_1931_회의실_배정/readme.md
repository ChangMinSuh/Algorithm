# 회의실 배정

- https://www.acmicpc.net/problem/1931

## 해설

그리디, 정렬

- 가장 빨리 끝나는 회의부터 최적을 찾아가면 된다.
- 2차원 배열 사용.
  - metting[][0] 은 start, metting[][1] 은 end.
  - end를 오름차순으로 정렬한다. 같을 경우에는 start를 오름차순으로.
- 정렬된 배열로 for문 시작
  - 현재 start가 마지막으로 나온 end 보다 작은 경우에는 겹쳐서 회의 불가능.
  - 회의가 가능할 경우에는 result + 1, 마지막으로 나온 end 업데이트
- 주의
  - (1,1), (0, 5) 인 경우도 고려.