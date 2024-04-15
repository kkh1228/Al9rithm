import sys
input = sys.stdin.readline

T=int(input())

for i in range(T):
    start, end = map(int, input().split(' '))
    distance = end-start
    cnt = 0 # 이동 횟수
    move = 1 # 이동 횟수의 빈도수, 이동 횟수 별 이동할 수 있는 최대 이동 거리
    move_plus = 0 # 이동한 거리의 합

    while move_plus < distance:
        cnt += 1
        move_plus += move
        if cnt % 2 == 0:
            move += 1

    print(cnt)