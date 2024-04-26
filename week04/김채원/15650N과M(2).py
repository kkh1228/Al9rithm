from itertools import combinations
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

result = combinations(range(1, N+1), M)

for sequence in result:
    print(' '.join(map(str, sequence)))