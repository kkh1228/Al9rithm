N, M = map(int, input().split())
card = list(map(int, input().split()))
ans = 0

# 3중 for문을 이용 해서 합이 M보다 크지 않는 경우를 모두 비교 했다.
for i in range(N):
    for j in range(i+1,N):
        for k in range(j+1,N):
            if card[i]+card[j]+card[k] > M:
                continue
            else:
                ans = max(ans, card[i]+card[j]+card[k])

print(ans)