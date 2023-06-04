import sys

input = sys.stdin.readline
n, m, r = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(str, input().split())))

for _ in range(r):
    for r in range(min(n, m)//2):
        x = r
        y = r
        value = graph[y][x]
        for d in range(r+1, n-r):
            y = d
            nvalue = graph[y][x]
            graph[y][x] = value
            value = nvalue

        for d in range(r+1, m-r):
            x = d
            nvalue = graph[y][d]
            graph[y][d] = value
            value = nvalue

        for d in range(r+1, n-r):
            y = n - 1 - d
            nvalue = graph[y][x]
            graph[y][x] = value
            value = nvalue

        for d in range(r+1, m-r):
            x = m - 1 - d
            nvalue = graph[y][x]
            graph[y][x] = value
            value = nvalue

for n in range(n):
    for m in range(m):
        print(graph[n][m], end=' ')
    print()