import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p149_음료수얼려먹기 {
    public static int[][] ices;
    public static int count = 0;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ices = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ices[i][j] = br.read() - '0';
            }
            br.readLine();
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ices[i][j] == 0) {
                    count++;
                }
                dfs(i, j);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int i, int j) {
        if (ices[i][j] == 1) {
            return;
        } else {
            ices[i][j] = 1;
            if (i + 1 < N) {
                dfs(i + 1, j);
            }
            if (0 < i) {
                dfs(i - 1, j);
            }
            if (j + 1 < M) {
                dfs(i, j + 1);
            }
            if (0 < j) {
                dfs(i, j-1);
            }
        }
    }
}
