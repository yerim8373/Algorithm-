import sys
from collections import deque
input = sys.stdin.readline

# f는 총 건물 층수, s는 지금있는 곳, g는 도착지(링크장), u은 up되는 정도, d는 down이 되는 정도
f, s, g, u, d = map(int, input().split()) 

dy = [u, -d]

floors = [0] *(f+1)
queue = deque([s])
floors[s] = 1
while queue:
    y = queue.popleft()

    for i in range(2):
        ny = y + dy[i]

        if 1 <= ny <= f and floors[ny] == 0:
            floors[ny] = floors[y] + 1
            queue.append(ny)

if floors[g] == 0:
    print("use the stairs")
else:
    print(floors[g]-1)