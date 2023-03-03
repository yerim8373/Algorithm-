import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        char cur;
        char next;

        for(int i=0;i<number.length();i++) {
            next = number.charAt(i);
            while(!stack.isEmpty() && k>0){
                cur = stack.pop();
                if (cur < next) {
                    k--;
                }
                else {
                    stack.add(cur);
                    break;
                }
            }
            stack.add(next);
        }
        while(k>0){
            stack.pop();
            k--;
        }

        for(char s : stack) {
            answer.append(s);
        }

        return answer.toString();
    }
}