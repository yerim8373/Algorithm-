class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int start = 0;
        char max = '0';
        for(int i = 0; i < number.length() - k; i++){
            max = '0';
            for(int j = start; j <= k + i; j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    start = j+1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}