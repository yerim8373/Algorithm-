import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) { // 해당 자릿수까리
            for (int j = 0; j < 10; j++) { // 0~ 9까지
                if(j == 0){
                    dp[i][j] = dp[i-1][j+1];
                }
                else if(j == 9){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = dp[i-1][j-1]+ dp[i-1][j+1];
                }
                dp[i][j] %= 1000000000;
            }
        }
        long sum =0; // 타입 주의
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }


        System.out.println(sum% 1000000000);
    }
}