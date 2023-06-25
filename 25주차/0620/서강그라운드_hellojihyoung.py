import sys
import heapq
input = sys.stdin.readline

INF = int(1e9)
n, m, r = map(int, input().split())
items = list(map(int, input().split()))
graph = [[] for i in range(n + 1)]

for i in range(r):
    a, b, l = map(int,input().split())
    graph[a].append((b, l))
    graph[b].append((a, l))

result = 0

for i in range(1, n + 1):
    distance = [INF] * (n + 1)
    q = []
    heapq.heappush(q, (0, i))
    distance[i] = 0
    while q:
        dist,now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    temp = 0
    for i,d in enumerate(distance):
        if d <= m:
            temp += items[i - 1]
    if temp > result:
        result = temp

print(result)