import heapq, sys
INF = int(1e9)
input = sys.stdin.readline

n, m, r = map(int, input().split())

area = list(map(int, input().split()))
area.insert(0, 0)

graph = [[] for _ in range(n+1)]


for _ in range(r):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])


def dijkstra(start):
    queue = []
    distance = [INF] * (n+1)
    distance[start] = 0
    heapq.heappush(queue, [0, start])
    while queue:
        dist, now = heapq.heappop(queue)
        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(queue, [cost, i[0]])
    return distance

val = 0
for i in range(1, n+1):
    tmp = 0
    total = dijkstra(i)

    for j in range(1, n+1):
        if total[j] <= m:
            tmp += area[j]

    val = max(val, tmp)

print(val)