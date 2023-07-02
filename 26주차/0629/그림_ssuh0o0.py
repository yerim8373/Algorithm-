import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(n) ]

dy = [-1, 0, 1, 0]
dx = [0, -1, 0, 1]

visited = [[False]*m for _ in range(n)]

def bfs(y, x):
    size = 1
    visited[y][x] = True
    queue = deque([[y, x]])
    while queue:
        y, x = queue.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < n and 0 <= nx < m and visited[ny][nx] == False:
                if board[ny][nx] == 1:
                    size += 1
                    visited[ny][nx] = True
                    queue.append([ny, nx])
    return size

answer = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 1 and visited[i][j] == False:
            answer.append(bfs(i, j))

if len(answer) > 0:
    print(len(answer))
    print(max(answer))
else:
    print(0)
    print(0)
