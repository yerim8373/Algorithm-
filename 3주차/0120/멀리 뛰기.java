class Solution {
    public long solution(int n) {
        long answer = 0;

        // 멀리 뛰기 연습
        // 효진이는 한 번에 1칸, 또는 2칸 가능
        // 칸이 총 4개 있을 때
        // 1 1 1 1
        // 1 2 1
        // 1 1 2
        // 2 1 1
        // 2 2
        // 5가지 방법 가능


        int[] dp = new int[n+1];

        dp[1] = 1;

        // n이 1인 경우
        if(n==1){
            return 1;
        }

        dp[2] = 2;

        // n이 2인 경우
        if(n==2){
            return 2;
        }

        else{
            for(int i = 3 ;i<=n; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
            }

            answer = dp[n];

            return answer;
        }
    }
}