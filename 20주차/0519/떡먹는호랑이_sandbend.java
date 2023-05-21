import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // 백준 DP

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        for (int i=1; i<=m/2; i++) {
            for (int j=i+1;j<m; j++) {
                dp[0] = i;
                dp[1] = j;
                for (int k=2; k<n; k++) {
                    dp[k] = dp[k-1] + dp[k-2];
                }
                if (dp[n-1] == m) {
                    bw.write(dp[0]+"\n");
                    bw.write(dp[1]+"");
                    break;
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
