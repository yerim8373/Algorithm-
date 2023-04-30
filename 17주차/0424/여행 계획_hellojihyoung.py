import sys
input = sys.stdin.readline()

def find(parent, x):
    if (parent[x] != x):
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, x, y):
    a = find(parent, x)
    b = find(parent, y)
    if (a < b):
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())
parent = [i for i in range(n+1)]

for i in range(n):
    row = list(map(int, input().split()))
    for j in range(n):
        if (row[j] == 1):
            union(parent, i, j)

plan = list(map(int, input().split()))

result = True
for i in range(m - 1):
    if find(parent, plan[i]) != find(parent, plan[i + 1]):
        result = False
        break

if (result == True):
    print('YES')
else:
    print('NO')