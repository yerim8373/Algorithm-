import sys
input = sys.stdin.readline

def find_parent(parent, planet):
    if parent[planet] == planet:
        return planet
    else:
        parent[planet] = find_parent(parent, parent[planet])
        return parent[planet]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n = int(input())
planet = []
x = []
y = []
z = []

for _ in range(n):
    planet.append(list(map(int, input().split())))

result = 0
edge = []

for p1 in range(n-1):
    for p2 in range(p1 + 1, n):
        x = abs(planet[p1][0] - planet[p2][0])
        y = abs(planet[p1][1] - planet[p2][1])
        z = abs(planet[p1][2] - planet[p2][2])
        edge.append([p1, p2, min(x, y, z)])
edge.sort(key=lambda n: n[2])

parent = [0] * (n+1)
for i in range(1, n+1):
    parent[i] = i

for a, b, cost in edge:
    if find_parent(parent, a) != find_parent(parent, b):
        result += cost
        union_parent(parent, a, b)

print(result)