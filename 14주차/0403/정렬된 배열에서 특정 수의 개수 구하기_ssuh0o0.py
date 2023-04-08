import sys
import time
input = sys.stdin.readline
n, m = map(int, input().split())
nlist = list(map(int, input().split()))
ss = time.time()

start = 0
end = n-1
up, down = n-1, 0
isUp, isDown = False, False
while start <= end:
    mid = (start+end)//2

    if (mid == n-1 or nlist[mid+1]>m) and nlist[mid] == m and isUp == False:
        up = mid
        start, end = 0, mid-1
        isUp = True
        continue
    elif (mid == 0 or nlist[mid-1]<m) and nlist[mid] == m and isDown == False:
        down = mid 
        start, end = mid + 1, n-1
        isDown = True
        continue

    if nlist[mid] > n:
        end = mid - 1
    else:
        start = mid + 1

answer = up-down+1
if nlist[0] != nlist[-1] and answer == n:
    print(-1)
else:
    print(answer)

ee = time.time()
print(f"{ee - ss:.5f} sec")