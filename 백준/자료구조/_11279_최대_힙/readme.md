# 최대 힙

- https://www.acmicpc.net/problem/11279

## 해설

우선순위 큐

- PriorityQueue 클래스를 이용하면 우선순위 큐 사용 가능.
  - Collections.reverseOrder() 혹은 람다함수를 사용하면 정렬 방법 재정의
- 0 입력 => remove()
  - 우선순위 큐가 비어있다면 remove에서 에러발생.
  - if문으로 따로 처리.
- 그 외의 자연수 => add()
