import sys
input = sys.stdin.readline

width = []
height = []
total = []

n = int(input())

for _ in range(6):
    direction, length = map(int, sys.stdin.readline().split())
    if direction == 1 or direction == 2:
        width.append(length)
        total.append(length)
    else:
        height.append(length)
        total.append(length)

big_square = max(width) * max(height)

max_width_index = total.index(max(width))
max_height_index = total.index(max(height))

small_height = abs(total[(max_width_index + 1) % 6] - total[(max_width_index - 1) % 6])
small_width = abs(total[(max_height_index + 1) % 6] - total[(max_height_index - 1) % 6])

print((big_square - (small_width * small_height)) * n)