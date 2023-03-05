public class 큰수만들기_sandbend {

    static class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            String answer = "";
            int index = 0;
            int next = 0;

            for (int i=0; i<number.length() - k; i++) {
                int max = 0;

                for (int j=index; j<=i+k; j++) {
                    int temp_num = number.charAt(j)-'0';
                    if (max < temp_num) {
                        max = temp_num;
                        next = j;
                    }
                }
                sb.append(max);
                index = next + 1;
            }
            answer = sb.toString();
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String number = "1924";
        int k = 2;
        System.out.println(method.solution(number, k));
    }
}
