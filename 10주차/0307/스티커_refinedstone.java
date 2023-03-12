import java.util.Scanner;

public class Test31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*초기값 세팅*/
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[][] score = new int[2][n];
            int[][] dp = new int[3][n];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    score[i][j] = sc.nextInt();
                }
            }
            /*dp 초기값 설정*/
            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];
            dp[2][0] = 0;

            /* dp 테이블 채우기*/
            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + score[0][i]; /*1번열 최대점수*/
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + score[1][i]; /*2번열 최대점수*/
                dp[2][i] = Math.max(Math.max(dp[0][i-1], dp[1][i-1]), dp[2][i-1]); /*i번째 최고의 선택*/
            }
            /*최대값 출력*/
            int maxScore = Math.max(Math.max(dp[0][n-1], dp[1][n-1]), dp[2][n-1]);
            System.out.println(maxScore);
        }
    }
}
