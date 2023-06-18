import sys
input = sys.stdin.readline
n = int(input())
dice = [ list(map(int, input().split())) for _ in range(n)]


def check_dice(arr, bot):
    for i in range(6):
        if arr[i] == bot:
            break
    
    new_bot, max_dice = 0, 0
    if i == 0:
        new_bot, max_dice = arr[5], max(arr[1], arr[2], arr[3], arr[4])
    elif i == 1:
        new_bot, max_dice = arr[3], max(arr[0], arr[2], arr[4], arr[5])
    elif i == 2:
        new_bot, max_dice = arr[4], max(arr[0], arr[1], arr[3], arr[5])
    elif i == 3:
        new_bot, max_dice = arr[1], max(arr[0], arr[2], arr[4], arr[5])
    elif i == 4:
        new_bot, max_dice = arr[2], max(arr[0], arr[1], arr[3], arr[5])
    elif i == 5:
        new_bot, max_dice = arr[0], max(arr[1], arr[2], arr[3], arr[4])

    return new_bot, max_dice
    
total = 0
for i in range(1, 7):
    bot = i

    answer = 0
    for j in range(n):
        bot, num = check_dice(dice[j], bot)
        answer += num
    if total < answer:
        total = answer
print(total)