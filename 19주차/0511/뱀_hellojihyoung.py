import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
graph = [ [0] * (n) for _ in range(n)]

for _ in range(k):
    x, y = map(int, input().split())
    graph[x-1][y-1] = 1

move = []
l = int(input())
for _ in range(l):
    x, c = map(str, input().split())
    move.append((int(x), c))

# 동남서북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def game():
    x, y = 0, 0 # start
    graph[x][y] = 2 # 뱀 머리
    direction = 0 # 동쪽
    time = 0
    snake = [(0, 0)] # 뱀 위치

    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]

        # 부딪히는지 확인 (몸, 벽)
        if (0 > nx or nx >= n or 0 > ny or ny >= n or graph[nx][ny] == 2 ):
            time += 1
            break

        else:
            if (graph[nx][ny] == 1): # 사과일 경우
                graph[nx][ny] = 2 # 이동
                snake.append((nx, ny))
            else:
                snake.append((nx, ny))
                graph[nx][ny] = 2 # 이동
                tx, ty = snake.pop(0) # 꼬리 제거
                graph[tx][ty] = 0 

        x, y = nx, ny
        time += 1

        if (len(move) != 0 and time == move[0][0]):
            if(move[0][1] == 'L'):
                direction = (direction - 1) % 4
            else:
                direction = (direction + 1) % 4
            move.pop(0)

    return time

print(game())