while True:
    sum = 0
    n = int(input())
    if n == 0:
        break
    else:
        arr = [True] * (2 * n + 1)
        arr[1] = False
        for i in range(2, int((2 * n)**0.5) + 1):
            if arr[i]:
                for j in range(i*i, 2 * n + 1, i):
                    arr[j] = False

        for i in range(n+1, n * 2 + 1):
            if arr[i] == True:
                sum += 1

        print(sum)