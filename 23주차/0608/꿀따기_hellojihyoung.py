import sys

input = sys.stdin.readline
 
n = int(input()) 
data = list(map(int, input().split())) 

answer = 0

sum = [] 
sum.append(data[0]) 

for i in range(1, n): 
    sum.append(sum[i - 1] + data[i]) 
    
for i in range(1, n - 1): 
    answer = max(answer, sum[n - 2]+sum[i - 1] - data[i])

for i in range(1,  n - 1): 
    answer = max(answer,  sum[n - 1] - data[0] - data[i] + sum[n - 1] - sum[i]) 

for i in range(1, n - 1): 
    answer = max(answer, sum[n - 2] - data[0] + data[i])
       
print(answer)