import sys
input = sys.stdin.readline
n = int(input())
work = []
for _ in range(n):
    work.append(list(map(int, input().split())))

dp = [0] * (n+1)
for i in range(n-1, -1, -1):
    if i + work[i][0] > n:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+1], dp[i+work[i][0]] + work[i][1])

print(dp[0])