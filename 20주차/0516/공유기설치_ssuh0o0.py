import sys
input = sys.stdin.readline
n, m = map(int, input().split())
nlist = []
for _ in range(n):
    nlist.append(int(input()))
nlist.sort()

start = 1
end = nlist[-1] - nlist[0]
answer = 0

def count(mid):
    cnt = 1
    num = nlist[0]
    for i in range(1, n):
        if nlist[i] >= num + mid:
            num = nlist[i]
            cnt += 1
    return cnt

while start <= end:
    mid = (start+end)//2
    num = count(mid)
    if num < m:
        end = mid -1   
    else:
        answer = mid
        start = mid + 1 
print(answer)