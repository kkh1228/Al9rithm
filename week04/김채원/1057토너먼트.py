import sys
input = sys.stdin.readline

N, A, B = map(int, input().split())

cnt = 0

while A != B:
    cnt += 1
    A = (A + 1) // 2
    B = (B + 1) // 2
    
    if A == B :
        break

print(cnt)
