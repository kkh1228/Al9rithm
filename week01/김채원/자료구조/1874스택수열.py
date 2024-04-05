n = int(input())
stack = []
output = []
cur = 1
boolean = True

for _ in range(n):
    num = int(input())

    if cur <= num:
        for i in range(cur, num+1):
            stack.append(i)
            output.append('+')
            cur += 1

    if stack[-1] == num:
        stack.pop()
        output.append('-')

    else:
        boolean = False

if boolean == True:
    for i in output:
        print(i)
else:
    print("NO")