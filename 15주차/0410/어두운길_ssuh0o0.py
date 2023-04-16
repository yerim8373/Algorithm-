import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split())
parent = [0] * (v)

for i in range(v):
    parent[i] = i
tot_cost = 0
edge = []
for _ in range(e):
    a, b, cost = map(int, input().split())
    tot_cost += cost
    edge.append((cost, a, b))

edge.sort()
result = 0
for e in edge:
    cost, a, b = e
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(tot_cost-result)