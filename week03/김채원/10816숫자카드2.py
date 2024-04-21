import sys
from collections import Counter

input = sys.stdin.readline


N = int(input())
num_card = list((map(int, input().split())))

M = int(input())
check_card = list((map(int, input().split())))

# check = [[0] for _ in range(len(check_card))]

# for i in range(len(check_card)):
#     cnt = 0
#     for j in range(len(num_card) -1 , -1, -1):
#         if check_card[i] == num_card[j]:
#             cnt += 1
#             del num_card[j]
#     check[i] = cnt

# for i in range(len(check)):
#     print(check[i], end=' ')
#     print()

# num_card의 각 요소의 등장 횟수를 세어 저장
num_count = Counter(num_card)
# Counter({10: 3, 3: 2, -10: 2, 6: 1, 2: 1, 7: 1})

# check_card의 각 요소가 num_card에서 몇 번 등장하는지 확인
#check_card의 각 card에 대해 num_count[card]를 조회
results = [num_count[card] for card in check_card]

print(" ".join(map(str, results)))