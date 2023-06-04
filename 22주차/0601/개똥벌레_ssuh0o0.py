import sys
input = sys.stdin.readline
n, h = map(int, input().split())

down = [0] * (h + 1) 
up = [0] * (h + 1)  
for i in range(n):
    if i % 2 == 0:
        down[int(input())] += 1
    else:
        up[int(input())] += 1

for i in range(h-1, 0, -1):
    down[i] += down[i+1]
    up[i] += up[i+1]

val = n
cnt = 0

for i in range(1, h+1):
    num = down[i] + up[h-i+1]
    if num < val:
        cnt = 1
        val = num
    elif num == val:
        cnt += 1

print(val, cnt)
        