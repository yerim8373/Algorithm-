import sys
from collections import deque

input = sys.stdin.readline

def bfs(n):
    q = deque([n])
    while q:
        n = q.popleft()
        if n == k:
            return array[n]
        for next in (n-1, n+1, 2*n):
            if 0 <= next < MAX and not array[next]:
                array[next] = array[n] + 1
                q.append(next)


MAX = 100001
n, k = map(int, input().split())
array = [0] * MAX
print(bfs(n))