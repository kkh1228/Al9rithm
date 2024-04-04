from queue import PriorityQueue
import sys
print = sys.stdout.write
input = sys.stdin.readline

# 우선 순위 큐는 선입선출 특성을 가진 일반 큐와 달리
# 데이터 추가는 어떤 순서로 해도 상관없지만, 제거될 때는 가장 작은 값을 제거한다.

# PriorityQueue의 put() 메서드를 사용하여 우선순위 큐에 원소를 추가 할 수 있다.
# PriorityQueue의 get() 메서드를 사용하여 가장 작은 원소를 삭제 할 수 있다.

# 단순 오름 차순이 아닌 (우선순위,값)의 튜플의 형태로 기준을 정해서 정렬 가능하다.


N = int(input())

myQueue = PriorityQueue()

for i in range(N):
    req = int(input())
    if req == 0:
        if myQueue.empty():
            print('0\n')
        else :
            temp = myQueue.get()
            print(str((temp[1]))+'\n')
            #temp에는 값이 (절대값,원래값) 형태의 튜플 형태로
            #저장되었기 때문에 출력할때는 temp[1]에 담긴 원래 값 출력.

    else:
        myQueue.put((abs(req),req))
        # (절대값, 원래값) 형태의 튜플로 데이터가 추가된다.
        # abs(req) 가 우선순위로 사용된다.

