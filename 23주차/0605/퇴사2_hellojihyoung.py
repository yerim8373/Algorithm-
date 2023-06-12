import sys
input = sys.stdin.readline 

n = int(input())
t, p = [], []
dp = [0] * (n+1)

for i in range(n):
    x, y = map(int,input().split())
    t.append(x)
    p.append(y)

num = 0 
for i in range(n):
    num = max(num, dp[i])  
    if i + t[i] > n :  
        continue 
    dp[i + t[i]] = max(num + p[i], dp[i + t[i]])

print(max(dp))