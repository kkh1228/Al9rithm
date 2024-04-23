import sys

# 재귀 호출 제한을 늘려 준다.
sys.setrecursionlimit(10 ** 6)
N = int(sys.stdin.readline())

# 그래프를 생성 하고 연결된 노드를 그래프에 추가 한다.
graph = [[] for i in range(N + 1)]
for i in range(N - 1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

# 방문 여부, 각 인덱스를 노드로 사용해 방문 했으면 0을 지우고, 부모 노드를 저장한다.
visited = [0] * (N + 1)


def dfs(node):
    for i in graph[node]:  # 해당 노드에 인접한 노드 중에서
        if visited[i] == 0:  # 방문한 적이 없다면
            visited[i] = node  # 해당 노드를 부모 노드로 저장
            # 방문 한 적 없는 인접한 노드에서 재귀적으로 함수를 호출
            dfs(i)

dfs(1)

for x in range(2, N + 1):
    print(visited[x])
