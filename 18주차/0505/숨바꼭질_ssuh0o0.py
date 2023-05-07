import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)
n,m = map(int, input().split())
distance = [-1] + [INF] * n
graph = [[] for _ in range(n+1)]

for i in range(m):
    a,b = map(int, input().split())
    graph[a].append((b,1))
    graph[b].append((a,1))

def dijkstra(start):
    queue = []
    distance[start] = 0
    heapq.heappush(queue, (0, start))

    while queue:
        dist, now = heapq.heappop(queue)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(queue,(cost, i[0]))

dijkstra(1)

node = 1
max_distance = max(distance)
for i in range(1, n+1):
    if distance[i] == max_distance:
        node = i
        break

print(node, max_distance, distance.count(max_distance))