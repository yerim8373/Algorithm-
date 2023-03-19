import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_sandbend {
    // 백준 퇴사2
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];

        StringTokenizer st; //문자열 분리
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        // dp : N일에 얻을 수 있는 최대 수익
        int[] dp = new int[n + 1];
        // 점화식
        // dp[i+t[i] = max(dp[i+t[i]], dp[i]+p[i])
        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) { // 날짜가 범위를 넘어가지 않는 경우
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); // 경우의 수가 0일 경우 이전의 최댓값
        }
        System.out.println(dp[n]);
    }
}