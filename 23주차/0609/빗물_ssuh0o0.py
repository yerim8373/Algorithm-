import sys
input = sys.stdin.readline
h, w = map(int, input().split())
blocks = list(map(int, input().split()))

water = 0
for i in range(1, w-1):
    l_top = max(blocks[ :i])
    r_top = max(blocks[i+1: ])
    
    top = min(l_top, r_top)
    if  top > blocks[i]:
        water += top - blocks[i]

print(water)