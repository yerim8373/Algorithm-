import sun.java2d.pipe.SolidTextRenderer;
import javax.sound.midi.Soundbank;

public class 타켓넘버_sandbend {
    static int answer = 0;
    static class Solution {
        public int solution(int[] numbers, int target) {
            dfs(numbers, 0, target, 0);
            return answer;
        }

        public void dfs(int[] numbers, int depth, int target, int sum) {
            if (depth == numbers.length) { // 마지막 노드까지 탐색한 경우
                if (target == sum) answer++;
            } else {
                dfs(numbers, depth+1, target, sum+numbers[depth]);
                dfs(numbers, depth+1, target, sum-numbers[depth]);
            }
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(method.solution(numbers,target));
    }
}
