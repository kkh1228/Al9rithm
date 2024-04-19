import sys
from collections import deque

input = sys.stdin.readline

def dfs(g,v,visited):
    visited[v] = True
    print(v, end=' ')
    for i in sorted(g[v]): #작은 노드부터 방문
        if not visited[i]:
            dfs(g,i,visited)

def bfs(g,v,visited):
    queue = deque([v])
    visited[v] = True

    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in sorted(g[v]): #작은 노드부터 방문
            if not visited[i]:
                visited[i] = True
                queue.append(i)


N, M, V = map(int, input().split())

graph = [[] for _ in range(N+1)]
dfs_visited = [False] * (N+1)
bfs_visited = [False] * (N+1)

for _ in range(M):
    i, j = map(int, input().split())
    graph[i].append(j)
    graph[j].append(i)

dfs(graph, V, dfs_visited)
print()
bfs(graph, V, bfs_visited)
print()