from collections import deque


def solution(n, board, direction):
    cnt = 0
    dx = 1
    dy = 0
    queue = deque([[0, 0]])
    
    while queue:
        y, x = queue[-1]
        
        ny, nx = y+dy, x+dx
        if ny < 0 or ny >= n or nx < 0 or nx >= n:
            break
        
        if board[ny][nx] == 0:
            a, b = queue.popleft()
            board[a][b] = 0
        elif board[ny][nx] == 2:
            break
        board[ny][nx] = 2
        queue.append([ny, nx])

        cnt += 1
        for time, dir in direction:
            if time == cnt:
                if dir == "L":
                    if dy == 0 and dx == 1:
                        dy, dx = -1, 0
                    elif dy == 1 and dx == 0:
                        dy, dx = 0, 1
                    elif dy == 0 and dx == -1:
                        dy, dx = 1, 0
                    else:
                        dy, dx = 0, -1
                elif dir == "D":
                    if dy == 0 and dx == 1:
                        dy, dx = 1, 0
                    elif dy == 1 and dx == 0:
                        dy, dx = 0, -1
                    elif dy == 0 and dx == -1:
                        dy, dx = -1, 0
                    else:
                        dy, dx = 0, 1
    return cnt 


n = int(input())
board = [[0]*n for _ in range(n)]
# 사과는 1, 뱀은 2
k = int(input())
for i in range(k):
    a, b = map(int, input().split())
    board[a-1][b-1] = 1
l= int(input())
direction = deque([])
for i in range(l):
    time, dir = input().split()
    direction.append([int(time), dir])

print(solution(n, board, direction)+1)