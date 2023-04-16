import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())

    emp = [0 for _ in range(n+1)]
    for _ in range(n):
        s, m = (list(map(int, input().split())))
        emp[s] = m

    cnt = 1
    min_emp = emp[1]
    for i in range(2, n+1):
        if min_emp > emp[i]:
            min_emp = emp[i]
            cnt += 1
    print(cnt)