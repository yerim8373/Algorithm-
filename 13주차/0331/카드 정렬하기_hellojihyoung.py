import sys
import heapq
input = sys.stdin.readline

n = int(input())
array = []

for i in range(n):
    heapq.heappush(array, int(input()))

count = 0
if len(array) == 1:
    print(0)
else: 
    while len(array) > 1:
        temp1 = heapq.heappop(array) 
        temp2 = heapq.heappop(array)
        count += (temp1 + temp2)
        heapq.heappush(array, (temp1 + temp2))

    print(count)