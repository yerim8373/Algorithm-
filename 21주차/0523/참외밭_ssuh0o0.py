import sys
input = sys.stdin.readline
n = int(input())
row = []
col = []
total = []
for _ in range(6):
    dir, length = map(int, input().split())
    if dir ==1 or dir == 2:
        row.append(length)
    else:
        col.append(length)
    total.append(length)

max_row_idx = total.index(max(row))
max_col_idx = total.index(max(col))

big = max(row) * max(col)
small = abs(total[(max_col_idx-1)%6]-total[(max_col_idx+1)%6]) * abs(total[(max_row_idx-1)%6]-total[(max_row_idx+1)%6])
print(n*(big-small))