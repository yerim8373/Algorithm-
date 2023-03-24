def solution(storey):
    answer = 0

    while storey:
        storey, mod = divmod(storey, 10)
        if mod < 5:
            answer += mod
        else:
            answer += 10 - mod
            if not (mod == 5 and storey%10 < 5):
                storey += 1
    return answer

print(solution(69943))