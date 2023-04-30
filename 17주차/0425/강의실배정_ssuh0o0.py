import sys
import heapq
input = sys.stdin.readline
n = int(input())
nlist = []
heap = []
for i in range(n):
    s, t = map(int, input().split())
    nlist.append([s, t])
nlist = sorted(nlist, key=lambda x:[x[0], x[1]])
heapq.heappush(heap, nlist[0][1])

cnt = 1
for i in range(1, n):
    cmp = heapq.heappop(heap)
    if cmp >= nlist[i][0]:
        cnt += 1
        heapq.heappush(heap, cmp)
    heapq.heappush(heap, nlist[i][1])
print(cnt)