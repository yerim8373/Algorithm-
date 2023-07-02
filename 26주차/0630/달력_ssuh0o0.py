import sys
input = sys.stdin.readline

n = int(input())
calendar = [0] * 367
for _ in range(n):
    start, end = map(int, input().split())
    for i in range(start, end+1):
        calendar[i] += 1

width = 0
height = 0
for i in range(1, 366):
    if not calendar[i-1] and calendar[i]:
        left = i
    if height < calendar[i]:
        height = calendar[i]
    if not calendar[i] and calendar[i-1]:
        right = i
        width += (right-left)* height
        height = 0
        left = 0
        right = 0
width += (366-left)* height

print(width)