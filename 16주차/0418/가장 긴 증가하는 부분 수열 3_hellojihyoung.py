import sys
input = sys.stdin.readline

n = int(input())
base = list(map(int, input().split()))

def binary_search(array, target, start, end):
    while start < end:
        mid = (start + end) // 2
        if array[mid] < target:
            start = mid + 1
        else:
            end = mid
    return end

answer = []
for num in base:
    if len(answer) == 0:
        answer.append(num)
        continue
    if num > answer[-1]:
        answer.append(num)
    else:
        index = binary_search(answer, num, 0, len(answer)-1)
        answer[index] = num

print(len(answer))