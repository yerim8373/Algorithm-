import sys
import heapq

input = sys.stdin.readline

n, m = map(int, input().split())
times = list(map(int, input().split()))
heap = []

times.sort(reverse=True)

for time in times:
    if len(heap) < m:
        heapq.heappush(heap, time)
    else:
        end = heapq.heappop(heap)
        heapq.heappush(heap, time + end)

print(max(heap))