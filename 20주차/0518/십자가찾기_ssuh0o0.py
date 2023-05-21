import sys
import copy
input = sys.stdin.readline
n, m = list(map(int, input().split()))
board = []
for _ in range(n):
    board.append(list(map(str, input().strip())))

check = [[False] * m for _ in range(n)]

answerList = []
board2 = copy.deepcopy(board)
for i in range(1, n):
    for j in range(1, m):
        if board[i][j] == "*":
            cnt = 0
            #위 오른쪽 아래 왼쪽
            u, r, d, l = i, j, i, j
            canCheck = True
            while canCheck:
                u -= 1
                r += 1
                d += 1
                l -= 1
                if u >= 0 and d < n and l >= 0 and r < m and board[u][j] == "*" and board[d][j] == "*" and board[i][l] == "*" and board[i][r] == "*":
                    cnt += 1
                    board2[u][j] = board2[d][j] = board2[i][l] = board2[i][r] = "."
                    answerList.append([i+1, j+1, cnt])
                else:
                    if cnt > 0 :
                        board2[i][j] = "."
                    canCheck = False

isOk = True
for bo in board2:
    if "*" in bo:
        isOK = False
        print(-1)
        break
if isOk:
    print(len(answerList))
    for ans in answerList:
        print(ans[0], ans[1], ans[2])

