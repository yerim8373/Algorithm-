import sys
input = sys.stdin.readline
n, m, l = list(map(int, input().split()))
road = [0, l] + list(map(int, input().split()))
road.sort()

start = 1
end = l

def countRestArea(mid):
    cnt = 0
    for i in range(1, len(road)):
        if road[i] - road[i-1] > mid:
            cnt += (road[i] - road[i-1]) // mid
            if (road[i] - road[i-1]) % mid == 0:
                cnt -= 1
    return cnt

result = 0
while start <= end:
    mid = (start + end)//2
    if countRestArea(mid) > m:
        start = mid + 1
    else:
        end = mid - 1
        result = mid

print(result)