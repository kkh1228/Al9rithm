# 파이썬에서는 list를 stack 처럼 사용 할 수 있다.
# stack은 후입 선출 방식이기 때문에 단어 순서를 뒤집을 때 사용해보았다.

N = int(input())
N_list = []

for i in range(N):
    sen = input().split()
    N_list.append(sen)

for j in range(N):
    print("Case #{}:".format(j+1), end=" ")
    for s in range(len(N_list[j])):
        print(N_list[j].pop(),end=" ")
    print()



# 아래 코드에서는 스택의 특성을 사용하지 않고 for문에서 역순으로 단어를 뒤집었다.
# N = int(input())
# N_list = []
#
# for i in range(N):
#     sen = input().split()
#     N_list.append(sen)
#
# for j in range(N):
#     print("Case #{}:".format(j + 1), end=" ")
#     for s in reversed(range(len(N_list[j]))):
#         print(N_list[j][s],end=" ")
#     print()

