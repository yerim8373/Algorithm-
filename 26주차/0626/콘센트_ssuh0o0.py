import sys, heapq
input = sys.stdin.readline
n, m = map(int, input().split())
times = list(map(int, input().split()))
times.sort(reverse=True)

arr = []
for t in times:
    if len(arr) < m:
        heapq.heappush(arr, t)
    else:
        heapq.heappush(arr, heapq.heappop(arr) + t)

print(max(arr))