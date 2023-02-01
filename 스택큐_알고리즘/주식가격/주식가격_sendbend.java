import java.util.Arrays;
import java.util.Stack;

public class 주식가격_sandbend {

    static class Solution {
        public int[] solution(int[] prices) {
            // 스택 활용
            int[] answer = new int[prices.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < prices.length; i++) {

                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                answer[stack.peek()] = prices.length - stack.peek() -1;
                stack.pop();
            }

            /*int[] answer = new int[prices.length];

            // 이중 for문 활용
            for (int i=0; i<prices.length; i++) {
                for (int j=i+1; j<prices.length; j++) {
                    answer[i]++;
                    if (prices[i] > prices[j])
                        break;
                }
            }*/
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(method.solution(prices)));
    }
}
