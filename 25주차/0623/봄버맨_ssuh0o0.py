import sys
input = sys.stdin.readline

r, c, n = map(int, input().split())
board = [list(input().strip()) for i in range(r)]

def bomb(prev, now):
    for y in range(r):
        for x in range(c):
            if prev[y][x]=='O': 
                now[y][x] = '.'
            else :
                for i, j in dir:
                    if 0 <= y+i < r and 0 <= x+j < c and prev[y+i][x+j]=='O':
                        now[y][x] = '.'
                        break
    return now

if n <= 1 :
    for second in board : 
        print(''.join(second))

elif n % 2 ==0 :
    for _ in range(r): 
        print('O'*c)

else :
    dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    third = bomb(board, [['O']*c for i in range(r)])
    fourth = bomb(third, [['O']*c for i in range(r)])

    if n % 4 == 3:
        for b in third : 
            print(''.join(b))
    if n % 4 == 1:
        for b in fourth : 
            print(''.join(b))