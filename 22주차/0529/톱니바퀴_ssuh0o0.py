from collections import deque
import sys
input = sys.stdin.readline

gears =  [deque(list(map(int, input().strip()))) for _ in range(4)]
gears.insert(0, []) 

n = int(input())
rotate = [list(map(int, input().split())) for _ in range(n)]


def rotate_left(num, dir, left):
    if num != 1:
        if left != gears[num - 1][2]:  
            ll = gears[num-1][6]
            gears[num-1].rotate(-dir)
            rotate_left(num - 1, -dir, ll)  


def rotate_right(num, dir, right):
    if num != 4:
        if right != gears[num + 1][6]:  
            rr = gears[num+1][2]
            gears[num+1].rotate(-dir)
            rotate_right(num+1, -dir, rr)  

for rot in rotate:
    left = gears[rot[0]][6]
    right = gears[rot[0]][2]
    gears[rot[0]].rotate(rot[1])
    rotate_left(rot[0], rot[1], left)
    rotate_right(rot[0], rot[1], right)

answer = 0
for i in range(1, 5):
    answer += gears[i][0]*(2**(i-1))

print(answer)