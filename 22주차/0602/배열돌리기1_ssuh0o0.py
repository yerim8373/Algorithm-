import sys
input = sys.stdin.readline
n, m, r = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

for _ in range(r):
    for i in range(min(n, m)//2):
        tmp = board[i][i]

        for j in range(i+1, m-i):
            board[i][j-1] = board[i][j]

        for j in range(i+1, n-i):
            board[j-1][m-1-i] = board[j][m-1-i]

        for j in range(m-i-1, i-1, -1):
            board[n-1-i][j] = board[n-1-i][j-1]

        for j in range(n-i-1, i, -1):
            board[j][i] = board[j-1][i]
   
        board[i+1][i] = tmp

for i in board:
    print(*i)