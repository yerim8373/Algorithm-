
import sys
input = sys.stdin.readline
n = int(input())
trees = list(map(int, input().split()))

if sum(trees) % 3 == 0:
    cnt = 0
    for i in trees:
        cnt += i //2
    if cnt >= (sum(trees) // 3):
        print("YES")
    else:
        print("NO")
else:
    print("NO")