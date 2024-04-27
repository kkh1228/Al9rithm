import sys
input = sys.stdin.readline

n = int(input())

num = [0,1,2]

for i in range(3, n+1):
    num.append(num[i-1]+ num[i-2])

print(num[n]%10007)