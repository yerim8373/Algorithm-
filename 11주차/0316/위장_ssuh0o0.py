def solution(clothes):
    answer = 1
    closet = {}
    
    for clo, t in clothes:
        if not t in closet:
            closet[t] = 1
        else:
            closet[t] += 1
    
    for v in closet.values():
        answer *= v+1
    return answer - 1