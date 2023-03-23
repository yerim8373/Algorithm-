import java.util.*;
class Solution {
    public static long solution(String expression) {
        ArrayList<String[]> ops = new ArrayList();
        ops.add(new String[] {"*","+","-"});
        ops.add(new String[] {"*","-","+"});
        ops.add(new String[] {"+","*","-"});
        ops.add(new String[] {"+","-","*"});
        ops.add(new String[] {"-","*","+"});
        ops.add(new String[] {"-","+","*"});

        long answer = 0;
        // 우선순위별로 계산값 구하고 절대값 비교해서 가장 큰 값 구하기
        for(String[] op: ops){    // 우선순위 별로
            StringBuilder ex = new StringBuilder();
            ex.append(expression);
            StringBuilder next = new StringBuilder();
            Deque<Long> numbers = new LinkedList<Long>();
            Deque<String> operators = new LinkedList<String>();
            Deque<Long> newNumbers;
            Deque<String> newOperators;
            for(String num:expression.split("\\D+")){
                numbers.offer(Long.parseLong(num));
            }
            String[] tmp = Arrays.stream(expression.split("\\d+")).filter(s -> !s.equals("")).toArray(String[]::new);
            for(String operator:tmp){
                operators.offer(operator);
            }
            for(String o: op){    // 연산자 별로
                newNumbers = new LinkedList<Long>();
                newOperators = new LinkedList<String>();
                newNumbers.offerLast(numbers.pollFirst());

                while(!numbers.isEmpty()){
                    String operator = operators.pollFirst();
                    if(o.equals(operator)){
                        long exNum = newNumbers.pollLast();
                        long nextNum = numbers.pollFirst();
                        long result = 0;
                        switch (o) {
                            case "+" -> result += exNum + nextNum;
                            case "*" -> result += exNum * nextNum;
                            case "-" -> result += exNum - nextNum;
                        }
                        newNumbers.offerLast(result);
                    }else{
                        newNumbers.offerLast(numbers.pollFirst());
                        newOperators.offerLast(operator);
                    }
                }
                numbers = newNumbers;
                operators = newOperators;
            }
            answer = Math.max(answer, Math.abs(numbers.pollLast()));
        }

        return answer;
    }
}
