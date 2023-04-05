import sys
input = sys.stdin.readline

n, m = map(int, input().split())
array = list(map(int, input().split()))

count = 0
def binary_search(target, data):
    start = 0
    end = len(data) - 1
    while start <= end:
        mid = (start + end) // 2
        if data[mid] == target:
            return True
        elif data[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return False

binary_search(m, arr)