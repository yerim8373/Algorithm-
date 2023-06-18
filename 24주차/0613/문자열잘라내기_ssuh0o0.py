import sys
input = sys.stdin.readline
r, c = map(int, input().split())
arr = [list(input()) for _ in range(r)]

result = 0
start, end = 0, r-1

def checkStr(mid):
    str_dict = {}
    for j in range(c):
        tmp = ''
        for i in range(mid, r):
            tmp += str(arr[i][j])
        if tmp not in str_dict:
            str_dict[tmp] = 1
        else:
            return False
    return True

while start <= end:
    mid = (start+end)//2
    
    if checkStr(mid):
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)