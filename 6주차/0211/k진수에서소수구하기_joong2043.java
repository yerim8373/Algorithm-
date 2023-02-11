class Solution {
    public static boolean isPrime(long n){
        if(n<=1){
            return false;
        }
        else if (n == 2){
            return true;
        }
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;

        // 진수 만들기
        String cimal = Integer.toString(n,k);

        String[] cimals = cimal.split("0");

        for(String s : cimals){
            if(s.equals("")){
                continue;
            }
            long number = Long.parseLong(s);
            if(isPrime(number)){
                answer++;
            }
        }

        return answer;
    }


}