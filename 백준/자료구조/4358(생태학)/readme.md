# 생태학

- https://www.acmicpc.net/problem/4358

## 해설

Map

- 전체를 다 탐색
  - N _ N => 1,000,000 _ 1,000,000 => 10억 훨심넘음.
- TreeMap 사용

  - N: 최대 나무 갯수, M: 최대 종류
  - NlogM => 1,000,000 \* 100 => 100,000,000 1억. 조금 아슬아슬하긴 함.

- 10.0과 같은 숫자도 4자리 소수점까지 표현하기 위해 String.format 사용.

```java
  String.format("%.4f", distribution)
```
