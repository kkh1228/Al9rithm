import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num_list = list(map(int, input().split()))

# for i in range(M):
#     sum = 0
#     i, j = map(int, input().split())
#     i -= 1
#     j -= 1

#     for k in range(i, j+1):
#         sum += num_list[k]

#     print(sum)

prefix_sum = [0] * (N+1)
for i in range(1, N+1):
    prefix_sum[i] = prefix_sum[i-1] + num_list[i-1]

for _ in range(M):
    sum = 0
    i, j = map(int, input().split())
    sum = prefix_sum[j] - prefix_sum[i-1]
    print(sum)
