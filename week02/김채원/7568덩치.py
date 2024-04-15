n = int(input())
weight = []
height = []
score = []

for i in range(n):
    first, second  = map(int, input().split(' '))
    weight.append(first)
    height.append(second)

for i in range(n):
    rank = 0
    for j in range(n):
        if weight[i] < weight[j] and height[i] < height[j]:
            rank += 1

    score.append(rank+1)

for rank in score:
    print(rank, end=' ') 
print()