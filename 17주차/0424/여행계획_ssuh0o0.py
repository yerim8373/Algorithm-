import sys
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
parent = [i for i in range(n+1)]
def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    x = find(parent, a)
    y = find(parent, b)
    if x > y:
        parent[x] = y
    else:
        parent[y] = x

for i in range(1, n+1):
    nlist = list(map(int, input().split()))
    for j in range(i, len(nlist)):
        if nlist[j] == 1:
            union(parent, i, j+1)

plan = list(map(int, input().split()))
p = parent[plan[0]]
for i in range(1, len(plan)):
    if p != parent[plan[i]]:
        print("NO")
        break
else:
    print("YES")