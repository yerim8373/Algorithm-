import sys
import heapq
input = sys.stdin.readline
n = int(input())

def find(parent, x):
    if (parent[x] != x):
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, x, y):
    a = find(parent, x)
    b = find(parent, y)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

nlist = []
for i in range(n):
    a, b, c = map(int, input().split())
    nlist.append([a, b, c, i])

edges = []
for i in range(3):
    nlist.sort(key=lambda x:x[i])
    for j in range(1, n):
        heapq.heappush(edges, [abs(nlist[j-1][i]-nlist[j][i]), nlist[j-1][3], nlist[j][3]])

parent = [i for i in range(n+1)]

result = 0

while edges:
    cost, a, b = heapq.heappop(edges)
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += cost
print(result)