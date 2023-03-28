from itertools import permutations

def solution(expression):
    result = 0
    operations = list(permutations(['*','-','+'], 3))
    for oper in operations:
        stack = []
        num = ''
        for exp in expression:
            if exp.isdigit():
                num += exp
            else:
                stack.append(num)
                stack.append(exp)
                num = ''
        stack.append(num)
        
        for o in oper:
            answer = []
            while stack:
                tmp = stack.pop(0)
                if tmp == o :
                    num1 = str(stack.pop())
                    num2 = str(stack.pop())
                    val = eval(num1+o+num2)
                    answer.append(val)
                else:
                    answer.append(tmp)
            stack = answer
        result = max(result, abs(int(stack[0])))
    return result

print(solution("100-200*300-500+20"))