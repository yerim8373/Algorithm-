import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[N+1];

        dp[1] = arr[1];
        if(N > 1)
            dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= N; i++) {
            // 마셨을 때
            dp[i] = Math.max(arr[i] + arr[i-1] + dp[i-3], dp[i-2] + arr[i]);
            // 안 마셨을 때
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        System.out.println(dp[N]);
    }
}