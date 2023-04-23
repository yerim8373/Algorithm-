import sys
input = sys.stdin.readline
n = int(input())
nlist = list(map(int, input().split()))

tmp = list(sorted(set(nlist)))
dic = {tmp[i]: i for i in range(len(tmp))}

for i in nlist:
    print(dic[i], end= " ")