# 지구 온난화

- https://www.acmicpc.net/problem/5212

## 해설

시물레이션

- 모든 지도를 돌면서 섬(X)이면 주위에 바다(.)인지 확인
  - 3,4개라면 #으로 바꿔줌.
    - 미래의 바다는 섬에 영향을 주면 안되므로 다른 문자로 치환.
  - 장외 또한 바다임.
- 2중 for문을 통해 출력할 지도 가로세로 위치 구함.
- 출력
  - #은 미래의 바다이므로 .으로 바꿔서 출력

