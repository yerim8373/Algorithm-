import sys
input = sys.stdin.readline

n, m, l = map(int, input().split())
arr = [0] + list(map(int,input().split())) + [l]
arr.sort()

distance = list(arr[i + 1] - arr[i] for i in range(len(arr)-1))

start = 1
end = l
length = 0

while start <= end:
    cnt = 0
    mid = (start + end) // 2
    for d in distance:
        if d > mid:
            cnt += (d - 1) // mid
    if cnt <= m:
        length = mid
        end = mid - 1
    else: 
        start = mid + 1

print(length)