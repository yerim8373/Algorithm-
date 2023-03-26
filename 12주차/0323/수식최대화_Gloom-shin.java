import java.util.*;

class Solution {

    //{+, - , * , /}
    long max;
    LinkedList<Character> operList;
    LinkedList<Long> numberList;
    ArrayList<Character> operation = new ArrayList<>(List.of('+', '-', '*'));

    public long solution(String expression) {


        System.out.println("operation = " + operation);

        operList = new LinkedList<>();
        numberList = new LinkedList<>();

        long answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (operation.contains(expression.charAt(i))) {
                numberList.add(Long.valueOf(sb.toString()));
                operList.add(expression.charAt(i));
                sb = new StringBuilder();
            } else {
                sb.append(expression.charAt(i));
            }

        }
        numberList.add(Long.valueOf(sb.toString()));
        char[] priority = new char[3];
        boolean[] visited = new boolean[3];
        // 분류하기

        backtracking(0, visited, priority);

        // 우선순위 정하기


        // 우선순위에 맞춰 계산하기
        return max;
    }

    private void backtracking(int n, boolean[] visited, char[] priority) {
        if (n == 3) {
            LinkedList<Character> operListCopy = (LinkedList<Character>) operList.clone();
            LinkedList<Long> numberListCopy = (LinkedList<Long>) numberList.clone();
            calculation(priority, operListCopy,numberListCopy);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            priority[n] = operation.get(i);
            visited[i] = true;
            backtracking(n + 1, visited, priority);
            visited[i] = false;

        }

    }


    private void calculation(char[] priority,   LinkedList<Character> operList,  LinkedList<Long> numberList) {

        for (char op : priority) {
            for (int j = 0; j < operList.size(); j++) {
                if (op == operList.get(j)) { // 우선 순위 연산
                    if (op == '+') {
                        numberList.set(j, numberList.get(j) + numberList.get(j + 1));
                    } else if (op == '-') {
                        numberList.set(j, numberList.get(j) - numberList.get(j + 1));
                    } else if (op == '*') {
                        numberList.set(j, numberList.get(j) * numberList.get(j + 1));
                    }
                    numberList.remove(j + 1);
                    operList.remove(j);
                    j--;
                }
            }

        }
        max = Math.max(max, Math.abs(numberList.get(0)));
        //계산을 끝내면

    }
}