N = int(input())

stack = []
ans = []
find = True

start = 1

for _ in range(N):
    cor = int(input())

    while start <= cor:
        stack.append(start)
        ans.append('+')
        start += 1

    # 스택의 맨 위 숫자와 cor이 같지 않으면 원하는 수열을 만들 수 없다.
    if stack[-1] == cor:
        stack.pop()
        ans.append('-')
    else:
        find = False


if not find:
    print('NO')
else:
    for i in ans:
        print(i)