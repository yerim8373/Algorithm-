class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int[] numbers = new int[number.length()];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Character.getNumericValue(number.charAt(i));
        }
        
        int maxIndex = -1;
        
        for (int i = 0; i < number.length() - k; i++) {
            int maxNumber = 0;
            for (int j = maxIndex + 1; j <= k + i; j++) {
                if (numbers[j] > maxNumber) {
                    maxNumber = numbers[j];
                    maxIndex = j;
                }
            }
            answer.append(maxNumber);
        }
        return answer.toString();
    }
}
