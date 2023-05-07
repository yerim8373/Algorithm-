import sys
INF =int(1e9)
input = sys.stdin.readline
n = int(input())
nlist = list(map(int, input().split()))

nlist.sort()

start = 0
end = n-1
result = [nlist[start], nlist[end]]
min_sum = INF

while start < end:
    now_sum = nlist[start] + nlist[end]
    if abs(now_sum) < min_sum:
        result =[nlist[start], nlist[end]]
        min_sum = abs(now_sum)
    
    if now_sum >= 0:
        end -= 1
    else:
        start += 1

print(*result)