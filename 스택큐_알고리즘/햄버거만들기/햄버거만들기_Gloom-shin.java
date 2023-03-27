import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int len = 0;
        for(int i= 0; i< ingredient.length; i++){
            stack.push(ingredient[i]);
            if(i >= 3){
                len = stack.size() - 1;
                if(stack.get(len) == 1 &&
                        stack.get(len-1) == 3 &&
                        stack.get(len-2) == 2 &&
                        stack.get(len-3) == 1){
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }

        return answer;
    }
}