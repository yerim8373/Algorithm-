import sys
input = sys.stdin.readline
n = int(input())
k = int(input())
nlist = list(map(int, input().split()))

if n <= k :
    print(0)
else:
    nlist.sort()
    dist = []
    for i in range(len(nlist)-1):
        dist.append(nlist[i+1]- nlist[i])

    dist.sort()
    for _ in range(k-1):
        dist.pop()

    print(sum(dist))