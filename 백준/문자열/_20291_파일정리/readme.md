# 파일정리

- https://www.acmicpc.net/problem/20291

## 해설

문자열, Map

- split으로 확장자를 받는다.
- Map을 사용하여 확장자명을 key로, 개수를 value로 받는다.
- key의 집합을 array로 변환 후 sort하여 순서대로 출력한다.

- Treemap을 사용하면 굳이 정렬을 하지 않아도 된다. 심지어 더 빠르다.