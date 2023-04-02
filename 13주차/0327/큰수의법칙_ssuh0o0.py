def solution(n, m, k, nlist):
    answer = 0
    nlist = sorted(nlist, reverse=True)
    first = nlist[0]
    second = nlist[1]

    while m:
        for _ in range(k):
            if m == 0:
                break
            answer += first
            m -= 1
            
        if m == 0:
            break
        answer += second
        m -= 1
    
    return answer

print(solution(5,8,3,[2,4,5,4,6])) # 46
print(solution(5,7,2,[3,4,3,4,3])) # 28
print(solution(2,10,3,[6,5])) # 58