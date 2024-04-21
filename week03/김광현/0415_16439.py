from itertools import combinations

N, M = map(int, input().split())

# like[i]에 개인 i에 대한 선호도 리스트가 저장 된다.
like = [list(map(int, input().split())) for _ in range(N)]

ans = 0

# combination 함수를 이용 해서 범위 내 세 인덱스의 모든 조합을 반복 한다.
for a, b, c in combinations(range(M), 3):
    tmp = 0
    # 각 개인 i의 조합중 최대 선호도가 가장 큰 값들을 더해 준다.
    for i in range(N):
        tmp += max(like[i][a], like[i][b], like[i][c])
    ans = max(ans, tmp)

print(ans)