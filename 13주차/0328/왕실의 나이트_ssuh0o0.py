def solution(a):
    answer = 0
    x, y = ord(a[0])-96, int(a[1])

    dx = [-1, 1, -1, 1, -2, 2, -2, 2]
    dy = [-2, -2, 2, 2, -1, -1, 1, 1]
    for i in range(8):
        if x+dx[i] > 0 and x+dx[i] < 9 and y+dy[i] > 0 and y+dy[i] < 9 :
            answer += 1
    return answer

print(solution("a1")) # 2
print(solution("h3")) # 4