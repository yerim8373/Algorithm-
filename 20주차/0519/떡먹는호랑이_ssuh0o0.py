import sys
input = sys.stdin.readline
d, k = map(int, input().split())
f, s = 1, 1
for i in range(d-3):
    f, s = s, f+s

# a, b,( a+b, a+2b, 2a+3b, 3a+5b, 5a+8b )
# 1, 1, 2, 3, 5, 8 , 13

a, b = 1, 1
while True:
    num = k - (f * a)
    if num % s == 0:
        print(a)
        print(num//s)
        break
    else:
        a += 1

