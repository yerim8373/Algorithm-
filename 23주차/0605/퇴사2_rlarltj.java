import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[][] dist = new int[num + 2][2];

		for (int i = 1; i <= num; i++) {
			st = new StringTokenizer(br.readLine());
			int days = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			dist[i][0] = days;
			dist[i][1] = cost;
		}

		int[] dp = new int[num + 2];
		//dp[i] = i일날 벌 수 있는 최대금액

		int max = 0;

		for (int i = 1; i <= num + 1; i++) {
			int days = dist[i][0];
			int cost = dist[i][1];

			int next = i + days;

			if (max < dp[i]) {
				max = dp[i];
			}

			if (next < num + 2) {
				dp[next] = Math.max(dp[next], max + cost);
			}
		}

		System.out.println(max);
	}
}
