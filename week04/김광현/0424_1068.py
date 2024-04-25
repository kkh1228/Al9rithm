N = int(input())
parent = list(map(int, input().split()))
delete = int(input())


def dfs(del_node):
    parent[del_node] = -10  # 제거 할 노드를 변경
    for i in range(N):
        if del_node == parent[i]:  # parent[i]가 del_node의 자식 이면 재귀를 통해 삭제
            dfs(i)


dfs(delete)
ans = 0
for i in range(N):
    if parent[i] != -10 and i not in parent:  # 제거된 노드가 아니고 i의 자식이 없다면
        ans += 1

print(ans)