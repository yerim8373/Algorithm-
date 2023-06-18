import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

vip = []
for i in range(0,m):
    k = int(input())
    vip.append(k)
seat = [1,1,2]
for i in range(3,41):
    seat.append(seat[i-2]+seat[i-1])
ans = 1
if m >= 1:
    pre = 0
    for i in range(0,m):
        ans = ans * seat[vip[i]-1-pre]
        pre = vip[i]
    ans = ans * seat[n-pre]
else:
    ans = seat[n]
print(ans)