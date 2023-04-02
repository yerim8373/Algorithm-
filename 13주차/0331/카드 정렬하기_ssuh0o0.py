import sys
import heapq
input = sys.stdin.readline
n = int(input())
answer = 0
heap = []

for _ in range(n):
    heapq.heappush(heap, int(input()))

while len(heap) > 1:
    f, s = heapq.heappop(heap), heapq.heappop(heap)
    answer += f + s
    heapq.heappush(heap, f + s)

print(answer)