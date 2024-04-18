N, M = map(int,input().split())
# N*N 크기의 2차원 리스트 생성 후, 모든 값을 무한대로 초기화.
graph = [[float('inf') for _ in range(N)] for _ in range(N)]

# M번 반복 하면서 이어진 건물 들을 입력 받고 이어진 해당 위치는 2로 초기화.
for i in range(M):
    a, b = map(int,input().split())
    graph[a-1][b-1] = 2
    graph[b-1][a-1] = 2

# 자기 자신 까지의 거리는 0으로 초기화.
for i in range(N):
    graph[i][i] = 0

# 플로이드 워셜 알고리즘을 사용 해서 모든 쌍의 최단 경로를 찾음.
# k는 중간 노드를 의미함
for k in range(N):
    # 시작 노드 i에서 도착 노드 j까지 최단 거리를 계산함.
    for i in range(N):
        for j in range(N):
            # 현재 최단 거리 보다 중간 노드인 k를 거쳐서 가는 것이 빠를 경우
            # 해당 값을 교체 해줌.
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

# 현재 까지의 최소 시간 min_time 을 무한대로 초기화.
min_time = float('inf')

# 2중 for 문으로 중복 되지 않는 치킨집 쌍만 고려함.
for i in range(N-1):
    for j in range(i,N):
        chicken1 = i
        chicken2 = j
        sum_time = 0
        # 모든 건물에 대해 치킨집 까지의 최소 이동 시간을 더해서 sum_time 에 초기화.
        for building in range(N):
            sum_time += min(graph[building][chicken1], graph[building][chicken2])
        # sum_time 이 min_time 보다 작을 경우 값을 바꿔 주고
        # 그때의 치킨집 위치를 저장 해줌.
        if min_time > sum_time:
            min_time = sum_time
            min_chicken1 = chicken1
            min_chicken2 = chicken2

print(min_chicken1 + 1, min_chicken2 + 1, min_time)
