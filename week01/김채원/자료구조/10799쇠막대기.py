n=input()

stack=[]
num = 0

for i in range(len(n)):
    if n[i]=="(":
        stack.append(n[i])
    elif n[i]==")":
        if len(stack)!=0:
            stack.pop()
            if n[i-1] == "(": # 이 부분만 알았어도...!
                num += len(stack)
            else:
                num += 1
print(num)