class Solution {
    public int[] solution(int n, long left, long right) {
        int num = (int) (right - left) + 1;

        int[] answer = new int[num];

        for (long i = left; i <= right; i++) {
            answer[(int) (i - left)] = Math.max((int) (i % n) + 1, (int) (i / n) + 1);
        }

        return answer;
    }
}