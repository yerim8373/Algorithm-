import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(arr[i], 10000001);
                arr[i][i] = 0;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                arr[start][end] = 1;
                arr[end][start] = 1;
            }
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken())-1;
            int K = Integer.parseInt(st.nextToken())-1;

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        arr[j][i] = Math.min(arr[i][j], arr[j][i]);
                    }
                }
            }

            int answer = arr[1][K] + arr[X][K];

            if (answer >= 10000001) System.out.println("-1");
            else System.out.println(answer);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
