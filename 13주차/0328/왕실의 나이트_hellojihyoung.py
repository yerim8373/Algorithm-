import sys
input = sys.stdin.readline

n = input()

move = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]
column = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']

x = int(column.index(n[0]))
y = int(n[1])

count = 0
for i in move:
    next_x = x + i[0]
    next_y = y + i[1]
    if next_x >= 1 and next_x <= 8 and next_y >= 1 and next_y <= 8:
        count += 1

print(count)