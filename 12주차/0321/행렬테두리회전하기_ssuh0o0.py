def solution(rows, columns, queries):
    answer = []
    table = [[j*columns+i+1 for i in range(columns)] for j in range(rows)] 

    for query in queries:
        x1, y1, x2, y2 = query[0]-1, query[1]-1, query[2]-1, query[3]-1
        minNum = tmp = table[x1][y1]

        # 왼
        for i in range(x1+1, x2+1):
            table[i-1][y1] = table[i][y1]
            minNum = min(minNum, table[i-1][y1])
    

        # 아
        for i in range(y1+1, y2+1):
            table[x2][i-1] = table[x2][i]
            minNum = min(minNum, table[x2][i-1])

        # 오
        for i in range(x2-1, x1-1, -1):
            table[i+1][y2] = table[i][y2]
            minNum = min(minNum, table[i+1][y2])

        # 위
        for i in range(y2-1, y1-1, -1):
            table[x1][i+1] = table[x1][i]
            minNum = min(minNum, table[x1][i+1])

        table[x1][y1+1] = tmp
        answer.append(minNum)

    return answer

print(solution(3,4,[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]))
