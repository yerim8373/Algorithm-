import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for(int i = 2; i <= N; i++){
            if(i == 2){
                dp[i] = 3;
                continue;
            }
            if(i == 4){
                dp[i] = 3 * 3 + 2;
                continue;
            }
            if(i % 2 == 0){
                dp[i] = dp[i - 2] * dp[2] + 2;
                for(int j = i - 4; j > 0; j -= 2){
                    dp[i] += dp[j] * 2;
                }
            }
        }

        System.out.println(dp[N]);

    }
}
