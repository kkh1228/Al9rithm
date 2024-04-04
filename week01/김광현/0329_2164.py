from collections import deque


N = int(input())

# deque는 큐이지만 앞,뒤 모두에서 요소를 추가/제거 할 수 있다.


myQueue = deque()

for i in range(1,N+1):
    myQueue.append(i)

while len(myQueue) > 1:
    myQueue.popleft()
    myQueue.append(myQueue.popleft())

print(myQueue[0])