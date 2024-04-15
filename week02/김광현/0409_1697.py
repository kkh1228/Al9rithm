from collections import deque

N, K = map(int, input().split())  # 출발 지점 N, 도착 지점 K 설정
# 100000 까지의 인덱스를 가지는 리스트를 생성, 방문 되지 않은 인덱스 0으로 초기화
visited = [0] * 100001

# bfs를 위한 큐 생성, 초기 상태로 출발 지점과 시간 포함
queue = deque([(N, 0)])

# 최단 시간을 비교 하기 위해 초기 값으로 큰값 입력
fast = 10 ** 6

# queue가 빌 때 까지 실행
while queue:
    # queue에 저장된 위치와 시간을 now, time에 저장
    now, time = queue.popleft()
    # queue에서 꺼낼 때 방문 처리를 하는 이유는 이미 발견된 경로가 있더라도
    # 다른 경로로 도달하는 경우를 고려하기 위함이다.
    visited[now] = 1

    # 현재 위치가 도착 지점 이고, 걸린 시간이 최단 시간과 같거나 작은 경우
    if now == K and time <= fast:
        fast = min(fast, time)

    # 현재 까지 걸린 시간이 최단 시간 보다 커지면 탐색을 종료 한다.
    if time > fast: break

    # 현재 위치에서 이동 할 수 있는 경우 세가지를 순회 하며,
    # 이동 한 위치가 범위 안에 있고 이미 방문 하지 않았다면 queue에 time값을 1 올려서 추가
    for x in (now - 1, now + 1, now * 2):
        if x in range(100001) and not visited[x]:
            queue.append((x, time + 1))

print(fast)
