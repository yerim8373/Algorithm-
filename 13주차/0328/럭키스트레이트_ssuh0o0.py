def solution(n):
    answer1 = 0
    answer2 = 0
    n = str(n)
    for i in range(len(n)//2):
        answer1 += int(n[i])
        answer2 += int(n[len(n)-1-i])
    return "LUCKY" if answer1 == answer2 else "READY"

print(solution(123402)) # LUCKY
print(solution(7755)) # READY
print(solution(123123600600)) # LUCKY