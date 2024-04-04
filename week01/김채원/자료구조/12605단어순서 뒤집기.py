N = int(input())
word = []

for i in range(1, N+1):
    word = input().split()

    re_word = reversed(word)
    str_re_word = ' '.join(re_word)

    print("Case #" + str(i) + ": " + str_re_word)