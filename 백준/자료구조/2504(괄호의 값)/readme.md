# 괄호 제거

- https://www.acmicpc.net/problem/2800

## 해설

---

- 재귀함수 이용.
- 괄호를 사용할지 안할지 2가지 경우로 나눠서 탐색 실행.
- isParenthesis 라는 Stack을 인자를 사용하여 괄호 유무 판단.
  - '('를 추가했는지 안했는지를 boolean값으로 push().
  - ')' 차레일 떄 pop().
  - clone 메서드를 사용해 스택 복사.
- 문장 끝에 도달하면 return(재귀 종료).
- ')' 문자일 때는 별개로 재귀함수 인자를 다르게 구성.
- Java의 TreeSet을 사용하여 정렬 및 중복 제거.
