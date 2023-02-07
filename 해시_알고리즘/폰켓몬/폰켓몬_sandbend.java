import java.util.HashSet;

public class 폰켓몬_sandbend {
    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            int max = nums.length / 2;
            HashSet<Integer> set = new HashSet<>();

            for (int n : nums) {
                set.add(n);
            }

            if (max >= set.size()) {
                answer = set.size();
            } else {
                answer = max;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {3,1,2,3};
        System.out.println(method.solution(nums));
    }
}
