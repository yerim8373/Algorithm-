public class Solution {

    public static void main(String[] args) {
        int storey1 = 16;
        int storey2 = 2554;

        System.out.println(solution(storey1)); // 6
        System.out.println(solution(storey2)); // 16
    }

    public static int solution(int storey) {
        int[] buttons = {100, 10, 1, -1, -10, -100};
        int result = 0;

        while (storey != 0) {
            int minDiff = Integer.MAX_VALUE;
            int selectedButton = 0;

            for (int button : buttons) {
                int newStorey = storey + button;

                if (newStorey >= 0 && Math.abs(newStorey) < minDiff) {
                    minDiff = Math.abs(newStorey);
                    selectedButton = button;
                }
            }

            storey += selectedButton;
            result++;
        }

        return result;
    }
}
