import sys
input = sys.stdin.readline
N, M = map(int, input().split())
locations = list(map(int, input().split()))

plus = []
minus = []
max_value = 0
answer = 0

for l in locations:
    if l > 0:
        plus.append(l)
    else:
        minus.append(l)

    if abs(l) > abs(max_value):
        max_value = l

plus.sort(reverse=True)
minus.sort()

distances = []

for i in range(0, len(plus), M):
    if plus[i] != max_value:
        distances.append(plus[i])

for i in range(0, len(minus), M):
    if minus[i] != max_value:
        distances.append(minus[i])

answer = abs(max_value)
for i in distances:
    answer += abs(i * 2)

print(answer)