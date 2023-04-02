import sys
input = sys.stdin.readline
n, m = map(int, input().split())


graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

_graph = [[0]*m for _ in range(n)]
dx = [1, 0, -1, 0 ] 
dy = [0, 1, 0, -1] 
answer = []
virusCnt = n * m

def virus(y, x):
    for i in range(4):
        ny = y+dy[i]
        nx = x+dx[i]
        if ny >= 0 and nx >= 0 and ny < n and nx < m:
            if _graph[ny][nx] == 0:
                _graph[ny][nx] = 2
                virus(ny, nx)

zeroCnt = 0
def dfs(cnt):
    global zeroCnt

    # 벽 3개 생성 완료
    if cnt == 3:
        for y in range(n):
            for x in range(m):
                _graph[y][x] = graph[y][x]

        for y in range(n):
            for x in range(m):
                if _graph[y][x] == 2:
                    virus(y, x)
        
        zero = 0
        for y in range(n):
            for x in range(m):
                if _graph[y][x] == 0:
                    zero += 1
        if zeroCnt< zero:
            zeroCnt = zero
        return

    # 벽 만듦
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                cnt += 1
                dfs(cnt)
                graph[i][j] = 0
                cnt -= 1

dfs(0)
print(zeroCnt)

