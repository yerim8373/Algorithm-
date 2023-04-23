import sys
input = sys.stdin.readline
n = int(input())
nlist = list(map(int, input().split()))

def binary_search(li, num):
    start, end = 0, len(li)-1
    while start <= end:
        mid = (start+end)//2
        if num > li[mid]:
            start = mid + 1
        else:
            end = mid - 1
    return start

num_list = [nlist[0]]
for i in range(1, n):
    start = binary_search(num_list, nlist[i])
    if start >= len(num_list):
        num_list.append(nlist[i])
    else:
        num_list[start] = nlist[i]

print(len(num_list))

# [5, 20]  여기에 5을 넣는 경우와 30을 넣는 경우
# 10 20 5 15 20 