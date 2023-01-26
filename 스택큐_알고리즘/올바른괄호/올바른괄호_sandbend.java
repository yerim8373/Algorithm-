import java.util.Arrays;
import java.util.Stack;

public class 올바른괄호_sandbend {

    static class Solution {
        boolean solution(String s) {
            boolean answer = false;

            // '( )'같은 문자이므로 Character
            Stack<Character> stack = new Stack<>();

            for (int i=0; i<s.length(); i++) {

                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                answer = true;
            }

            return answer;
        }
    }


    public static void main(String[] args) {
        Solution method = new Solution();
        String s = "()()";
        System.out.println(method.solution(s));
    }
}
