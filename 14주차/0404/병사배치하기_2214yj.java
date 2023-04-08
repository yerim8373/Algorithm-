import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] soldiers = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            soldiers[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                if(dp[j] >= dp[i] && soldiers[j] > soldiers[i] ){   // 앞의 병사들의 전투력이 자신보다 크고 최대값도 자신보다 크거나 같다면
                    dp[i] = dp[j] + 1;  // 자신을 추가한 최대값을 갱신한다.
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(N - dp[N]);

    }

}
