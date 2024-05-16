K = int(input())  # 트리의 높이 입력
input_array = list(map(int, input().split()))
# K 높이의 이진 트리를 표현할 2차원 리스트 생성
tree = [[] for _ in range(K)]


def make_tree(arr, x):  # 재귀 함수를 통해 이진 트리 생성
    # 길이를 2로 나눠서 루트 노드를 찾는다
    mid = (len(arr) // 2)
    # 현재 높이에 해당 하는 트리 리스트에 현재 노드 값을 추가
    tree[x].append(arr[mid])
    # 현재 리스트의 길이가 1이면 종료
    if len(arr) == 1:
        return

    # 왼쪽과 오른쪽 서브 트리를 만들기 위해 배열의 왼쪽 부분을 재귀적으로 탐색
    make_tree(arr[:mid], x + 1)
    make_tree(arr[mid + 1:], x + 1)


make_tree(input_array, 0)

# 만들어진 이진 트리를 각 높이에 따라 출력
for i in range(K):
    print(*tree[i])