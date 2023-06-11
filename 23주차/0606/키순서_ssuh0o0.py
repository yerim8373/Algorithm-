import sys
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

def dfs(now, idx):
    for gra in graph[idx]:
        if not knowHeight[now][gra]:
            knowHeight[now][gra] = 1
            knowHeight[gra][now] = 1
            dfs(now, gra)

knowHeight = [[0] * (n+1) for _ in range(n+1)]
for i in range(1, n+1):
    knowHeight[i][i] = 1
    dfs(i, i)

answer = 0
for i in range(1, n+1):
    if sum(knowHeight[i]) == n:
        answer += 1

print(answer)