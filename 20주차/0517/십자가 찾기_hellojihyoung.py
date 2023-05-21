import sys
input = sys.stdin.readline

n, m = map(int, input().split())

visited = [[0 for i in range(m)] for j in range(n)]

board = []
ans = []

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def find(x, y):
    for s in range(1, m):
        flag = True
        for i in range(4):
            nx = x + dx[i] * s
            ny = y + dy[i] * s
            if 0 <= nx < m and 0 <= ny < n and board[ny][nx] == '*':
                pass
            else:
                flag = False
                break
        if flag:
            ans.append([y + 1, x + 1, s])
            for i in range(4):
                ny = y + dy[i] * s
                nx = x + dx[i] * s
                visited[ny][nx] = 0
            visited[y][x] = 0
        else:
            break

for i in range(n):
    board.append(input().strip())

for i in range(n):
    for j in range(m):
        if board[i][j] == '*':
            visited[i][j] = 1

for i in range(n):
    for j in range(m):
        if board[i][j] == '*':
            find(j, i)

total = 0
for i in range(n):
    for j in range(m):
        total += visited[i][j]

if total == 0:
    print(len(ans))
    for a in ans:
        print(*a)
else:
    print(-1)