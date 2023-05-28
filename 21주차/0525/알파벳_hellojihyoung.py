import sys
input = sys.stdin.readline

r, c = map(int, input().split())
graph = [list(input()) for _ in range(r)]
visited = set()
dx, dy = (-1, 1, 0, 0), (0, 0, -1, 1)
answer = 0


def dfs(x, y, count):
    global answer

    answer = max(answer, count)
    visited.add(graph[x][y])

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]

        if 0 <= nx < r and 0 <= ny < c:
            if graph[nx][ny] not in visited:
                dfs(nx, ny, count + 1)

    visited.remove(graph[x][y])


dfs(0, 0, 1)

print(answer)