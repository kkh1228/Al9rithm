from collections import deque


def bfs(x, y, color):  # 시작 지점의 좌표, 탐색할 색
    cnt = 0  # 찾은 병사 수
    queue = deque()  # bfs를 위한 큐
    queue.append((x, y))  # 시작 지점을 큐에 삽입
    graph[x][y] = 0  # 해당 위치를 방문 처리

    while queue:  # 큐가 빌 때까지 반복
        x, y = queue.popleft()  # 큐에서 하나의 위치를 꺼냄
        cnt += 1  # 해당 위치의 병사 수 증가
        for i in range(4):  # 해당 위치에서 상하좌우로 이동
            nx = x + dx[i]
            ny = y + dy[i]
            if (0 <= nx < m and 0 <= ny < n):  # 이동할 위치가 범위 내에 있는지 확인
                if (graph[nx][ny] == color):  # 같은 색이라면
                    queue.append((nx, ny))  # 해당 위치를 큐에 추가하
                    graph[nx][ny] = 0  # 해당 위치 방문 처리
    return cnt


n, m = map(int, input().split())  # 가로와 세로 크기 입력
graph = [list(input()) for _ in range(m)]  # W,B로 구성된 행렬 생성
dx = [-1, 1, 0, 0]  # x축 이동 변화량
dy = [0, 0, -1, 1]  # y축 이동 변화량

white = 0  # 흰색 병사 수 초기화
blue = 0  # 파란색 병사 수 초기화

# 모든 위치에 대해서 흰색과 파란색 병사 수 계산. 인접한 병사 수를 구하기 위해 bfs함수 호출
for i in range(m):
    for j in range(n):
        if (graph[i][j] == 'W'):
            white += (bfs(i, j, 'W')) ** 2
        elif (graph[i][j] == 'B'):
            blue += (bfs(i, j, 'B')) ** 2

print(white, blue)