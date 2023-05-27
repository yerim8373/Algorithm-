import sys
input = sys.stdin.readline
R, C = map(int, input().split())
board = [list(input().strip()) for _ in range(R)]
dy = [-1, 0, 1, 0]
dx = [0, -1, 0, 1]
answer = 1
def bfs(y, x):
    global answer
    queue = set([(y, x, board[y][x])])
    while queue:
        y, x, ans = queue.pop()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ((0 <= ny < R) and (0 <= nx < C)) and (board[ny][nx] not in ans):
                queue.add((ny, nx, ans + board[ny][nx]))
                answer = max(answer, len(ans)+1)

bfs(0, 0)
print(answer)