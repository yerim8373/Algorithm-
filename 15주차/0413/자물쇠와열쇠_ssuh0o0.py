def put_key(x, y, m, key, board):
    for i in range(m):
        for j in range(m):
            board[x+i][y+j] += key[i][j]
            
def detach_key(x, y, m, key, board):
    for i in range(m):
        for j in range(m):
            board[x+i][y+j] -= key[i][j]

def rotate(key):
    n = len(key)
    tmp = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            tmp[j][n-i-1] = key[i][j]
    return tmp


def check(board, m, n):
    for i in range(n):
        for j in range(n):
            if board[m+i][m+j] != 1:
                return False
    return True

def solution(key, lock):
    m, n = len(key), len(lock)

    board = [[0] * (m*2 + n) for _ in range(m*2 + n)]

    for i in range(n):
        for j in range(n):
            board[m+i][m+j] = lock[i][j]


    for _ in range(4):
        key = rotate(key)
        for x in range(1, m+n):
            for y in range(1, m+n):

                put_key(x, y, m, key, board)

                if(check(board, m, n)):
                    return True

                detach_key(x, y, m, key, board)
                
    return False

print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], 	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]))