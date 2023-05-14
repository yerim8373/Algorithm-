import sys
input = sys.stdin.readline

n = int(input())
apple = list(map(int, input().split()))
apple_sum = sum(apple)
turn = apple_sum // 3

if apple_sum % 3 != 0:
    print('NO')
else:
    for a in apple:
        turn -= (a//2)
    if turn > 0:
        print('NO')
    else:
        print('YES')