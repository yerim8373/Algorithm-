import sys
input = sys.stdin.readline

r, c, n = map(int, input().split())
board = [list(input()) for _ in range(r)]
direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]
find_bomb = lambda li: [(i, j) for j in range(c) for i in range(r) if li[i][j] == 'O']
bombs = []

def fill_bombs(board): 
    board = [['O'] * c for _ in range(r)]

def explode(board, bombs):
    for bx, by in bombs:
        board[bx][by] = '.'
        for i in range(4):
            nx, ny = bx + direction[i][0], by + direction[i][1]
            if nx in range(r) and ny in range(c):
                board[nx][ny] = '.'

for time in range(1, n):
    if time % 2 == 1:
        bombs = find_bomb(board)
        fill_bombs(board)
    else:
        explode(board, bombs)

for b in board:
    print(''.join(b))