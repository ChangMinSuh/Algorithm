# 수들의 합4

- https://www.acmicpc.net/problem/2015

## 해설

누적합, 해시맵


- 누적합을 만들고 하나하나씩 계산하면 정답. 하지만 시간초과
  - ex) sum[] = {2, 0, 2, 0} K = 0;
  - 0 ~ N = sum[0], sum[1], sum[2], sum3[3]. K = 0
  - 1 ~ N = sum[1], sum[2], sum[3] 에 sum[0] 빼줌. K = 0
  - 2 ~ N = sum[2], sum[3] 에 sum[1] 빼줌. K = 0
  - 결국 2중 포문으로 시간초과..
- 역으로 K 값을 움직이면 됨.
  - 0 ~ N = sum[0], sum[1], sum[2]. sum3[3], K = 0
  - 1 ~ N = sum[1], sum[2], sum[3]. K = sum[0]
  - 2 ~ N = sum[2], sum[3]. K = sum[1] 

- sum변수를 이용해 누적합 저장
- sumMap변수를 이용해 누적합의 개수를 저장
  - sumMap에 0 ~ i 까지의 합들의 모든 경우 저장
    - sumMap의 Key: 0 ~ i 까지의 합
    - sumMap의 value:  key의 개수

sumMap을 이용해 K 값을 변경해가며 구한다.