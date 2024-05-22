import sys
from collections import defaultdict
input = sys.stdin.readline

while True:
    N, K = map(int, input().split())
    if [N, K] == [0, 0]:  # N,K 가 둘다 0일 경우에 루프 종료.
        break
    L = list(map(int, input().split()))  # 리스트 에 트리의 노드 값을 순서 대로 저장.

    # 각 노드의 부모 노드를 저장 하기 위한 defaultdict 생성.
    Parent = defaultdict(int)  # 초기 값은 0으로 초기화 됨.
    index = 0  # 현재 부모 노드를 의미 하는 인덱스

    for i in range(1, N):
        Parent[L[i]] = L[index]  # 두번째 노드 부터 부모 노드를 설정 해줌.
        #  L[i] 와 L[i+1] 이 연속 되는 수가 아니면 부모 노드를 의미 하는 인덱스 값을 증가 시킨다.
        if i < N-1 and L[i] + 1 < L[i+1]:
            index += 1

    count = 0
    #  두 노드의 부모의 부모 노드가 같고 부모 노드가 서로 다른 경우에 사촌 관계.
    if Parent[Parent[K]]:  # K의 부모의 부모가 존재 하는지 확인.
        for Node in L:
            #  리스트를 순회 하면서 위 조건에 따라 count 값 증가.
            if ((Parent[Parent[K]] == Parent[Parent[Node]]) and
                    Parent[Node] != Parent[K]):
                count += 1
    print(count)