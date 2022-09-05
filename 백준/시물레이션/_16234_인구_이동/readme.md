# 인구 이동

- https://www.acmicpc.net/problem/16234

## 해설

bfs

- for문을 통해 모든 값을 하나하나 bfs 돌림
  - queue 대신 ArrayList 사용
    - 최종 list에 들어있는 값은 국경선을 공유하는 나라들.
    - 대신 cnt 변수 사용하여 검사.
  - 인접한 나라의 인구수 차가 L과 R 사이 값이라면 list에 삽입
  - list의 값을 평균내어 각 배열에 삽입한다.
  - 최종 변경이 없을 때 까지 while문
    - 모든 나라에서 list가 1이라면 최종 변경이 없는 것!
    - (while문 실행 한 개수 - 최종변경 유무) 가 정답.