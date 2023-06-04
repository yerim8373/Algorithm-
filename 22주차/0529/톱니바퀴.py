import sys
from collections import deque

input = sys.stdin.readline

def checkRight(index, clockWise):
    if index > 3 or gears[index-1][2] == gears[index][6]:
        return
    if gears[index-1][2] != gears[index][6]:
        checkRight(index+1, -clockWise)
        gears[index].rotate(clockWise)

def checkLeft(index, clockWise):
    if index < 0 or gears[index][2] == gears[index + 1][6]:
        return
    if gears[index][2] != gears[index + 1][6]:
        checkLeft(index-1, -clockWise)
        gears[index].rotate(clockWise)

gears = []
for i in range(4):
    gears.append(deque(list(input().rstrip())))

K = int(input())
for i in range(K):
    gear, clockWise = map(int, input().split())
    checkRight(gear, -clockWise)
    checkLeft(gear-2, -clockWise)
    gears[gear-1].rotate(clockWise)

result = 0
for i in range(4):
    if gears[i][0] == '1':
        result += (2**i)

print(result)