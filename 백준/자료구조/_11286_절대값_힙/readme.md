# 최대 힙

- https://www.acmicpc.net/problem/11286

## 해설

우선순위 큐

- PriorityQueue 클래스를 이용하면 우선순위 큐 사용 가능.
  - 절대값으로 오름차순, 절대값이 같다면 같은 수에서 오름차수
  - 람다함수 사용. Javascript와 유사.
  ```java
        (o1, o2) ->
                Math.abs(o1) - Math.abs(o2) == 0
                        ? o1 - o2
                        : Math.abs(o1) - Math.abs(o2)
  ```
- 0 입력 => remove()
  - 우선순위 큐가 비어있다면 remove에서 에러발생.
  - if문으로 따로 처리.
- 그 외의 자연수 => add()
