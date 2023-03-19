import java.util.Scanner;

public class Test34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] t = new int[N];
        int[] p = new int[N];
        /*dp*/
        int[][] dp = new int[2][N+2];
        for (int i = 0; i < N; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        /*초기값
        * dp는 i날에 얻을 수 있는 최대 이익
           [0][i] = i날의 상담을 한다.
           [1][i] = i날의 상담을 안한다.
         */
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = p[0];
        dp[1][1] = 0;

        /*시작*/
        for (int i = 1; i < N+1; i++) {
            if(i+t[i-1]-1 <= N+1) {
                dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1])+p[i];
                dp[1][i] = Math.max(dp[0][i-1],dp[1][i-1]);
            }
            else{
                dp[0][i] = dp[0][i-1];
                dp[1][i] = Math.max(dp[0][i-1],dp[1][i-1]);
            }
        }
        System.out.println(Math.max(dp[0][N+1], dp[1][N+1]));
    }
}
