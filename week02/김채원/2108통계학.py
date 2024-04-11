import sys
input = sys.stdin.readline

N = int(input())
num_list = []
num_dict = {}

for i in range(N):
    num = int(input())
    num_list.append(num)
    num_dict[num] = 0

num_list.sort()

mean = round((sum(num_list) / N))
median = num_list[N//2]
mode = 0
num_range = max(num_list) - min(num_list)

# 최빈값 찾는 과정
for i in range(N):
    num_dict[num_list[i]] += 1

# 최대 빈도수 계산
max_freq = max(num_dict.values())

# 최대 빈도수를 가진 모든 키 찾기
max_keys = [key for key, value in num_dict.items() if value == max_freq]
# max_keys = []
# for key, value in num_dict.items():
#     if value == max_freq:
#         max_keys.append(key)

max_keys.sort()

# 두 번째로 작은 키 출력
if len(max_keys) > 1:
    mode = max_keys[1]
else:
    mode = max_keys[0]

print(mean)
print(median)
print(mode)
print(num_range)