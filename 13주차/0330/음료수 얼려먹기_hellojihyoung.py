n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int, input())))

def DFS(x, y):
    if x <0 or x >= n or y < 0 or y >= m:
        return False
    
    if graph[x][y] == 0:
        graph[x][y] = 1
        DFS(x, y - 1)
        DFS(x, y + 1)
        DFS(x + 1, y)
        DFS(x - 1, y)
        
        return True
    return False

count = 0
for i in range(n):
    for j in range(m):
        if DFS(i, j) == True:
            count += 1

print(count)   