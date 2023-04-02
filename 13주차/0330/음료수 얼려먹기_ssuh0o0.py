from collections import deque
n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int,input().strip())))

dx = [1, 0, -1, 0 ] # 오른쪽 아래 왼쪽 위
dy = [0, 1, 0, -1] 

def dfs(y, x):
    if y >= 0 and x >= 0 and y < n and x < m:
        if graph[y][x] == 0:
            graph[y][x] = 2
            for i in range(4):
                dfs(y+dy[i], x+dx[i])
            return True
    return False
    
cnt = 0
for i in range(n):
    for j in range(m):
        if dfs(i , j):
            cnt += 1

print(cnt)
