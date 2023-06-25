import sys
from collections import deque
input = sys.stdin.readline

def bfs(y, x):
    queue = deque([[y, x]])
    while queue:
        y, x = queue.popleft()
        if abs(y - festival[0]) + abs(x - festival[1]) <= 1000:
            print("happy")
            return

        for i in range(n):
            if not visited[i]:
                ny, nx = conv[i]
                if abs(y - ny) + abs(x - nx) <= 1000:
                    queue.append([ny, nx])
                    visited[i] = 1
    print("sad")
    return


t = int(input())
for _ in range(t):
    n = int(input())

    house = list(map(int, input().split()))
    conv = []
    for i in range(n):
        y, x = map(int, input().split())
        conv.append([y, x])
    festival = list(map(int, input().split()))
    visited = [0 for i in range(n+2)] 
    bfs(house[0], house[1]) 
    bfs(house[1], house[2])
    bfs(house[2], house[3])
