import sys

input = sys.stdin.readline
n = int(input())
b = list(map(int, input().split()))

a = []

for num in b:
    can3 = 0
    num_origin = num
    while True:
        if num % 3 == 0:
            can3 += 1
            num //= 3
        else:
            break
    a.append([can3, num_origin])

a.sort(key= lambda x: (-x[0], x[1]))
for i in range(n):
    print(a[i][1], end=' ')