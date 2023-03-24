class Solution {
    public static int solution(int storey) {
        int cnt = 0;
        int cur = storey % 10;
        int next = storey / 10;
        while(next > 0){
            if(cur == 5 && (next % 10) >= 5){
                cnt += 5;
                next += 1;
            }else if(cur > 5){
                cnt += 10 - cur;
                next += 1;
            }else{
                cnt += cur;
            }
            cur = next % 10;
            next = next / 10;
        }
        cnt += Math.min(cur, 10 - cur + 1);
        return cnt;
    }
}