import sys
from collections import deque

input = sys.stdin.readline

def miro(x,y):
    # 상,하,좌,우 정의
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((x,y))

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<N and 0<=ny<M and graph[nx][ny] == 1:
                queue.append((nx,ny))
                #방문하면 +1로 해서 다시 방문하지 않을 수 있음
                graph[nx][ny] = graph[x][y]+1

    return graph[N-1][M-1]

N, M = map(int, input().split())

graph=[]

for i in range(N):
    connection = list(map(int, input().strip()))
    graph.append(connection)

print(miro(0,0))