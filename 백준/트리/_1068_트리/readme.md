# 트리

- https://www.acmicpc.net/problem/1068

## 해설

n진트리 dfs

- 자식 노드와의 관계를 나타내는 Tree 배열 선언.
- Tree 배열에는 **루트와 지워야하는 노드의 정보**를 0으로 나타냄.
- 탐색으로 리프노드일때 return 값 +1함.
- 이떄, **루프 노드는 노드의 차수가 0인것으로 구분**할 수 있음.
