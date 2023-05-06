import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

arr.sort()

left = 0
right = n-1

answer = abs(arr[left] + arr[right])
final = [arr[left], arr[right]]

while left < right:
    left_num = arr[left]
    right_num = arr[right]

    sum = left_num + right_num

    if abs(sum) < answer:
        answer = abs(sum)
        final = [left_num, right_num]
        if answer == 0:
          break

    if sum < 0:
        left += 1
    else:
        right -= 1

for i in final:
    print(i, end=' ')
