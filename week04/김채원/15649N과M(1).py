from itertools import permutations
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

result = permutations(range(1, N+1), M)

for sequence in result:
    print(' '.join(map(str, sequence)))