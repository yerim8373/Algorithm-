import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] link;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        link = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                link[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isOk = true;
        for (int i = 0; i < M - 1; i++) {
            isOk = find(plan[i], plan[i + 1], 0);
            if (!isOk) break;
        }

        System.out.println(isOk ? "YES" : "NO");

    }

    public static boolean find(int start, int end, int cnt) {

        if (start == end) {
            return true;
        }
        if (cnt == N) {
            return false;
        }
        for (int i = 1; i <= N; i++) {
            if (link[start][i] == 1) {
                boolean result = find(i, end, cnt + 1);
                if (result) return result;
            }
        }
        return false;
    }
}
