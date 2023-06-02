import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Math.min(N ,M) / 2;

        for (int q = 0; q < R; q++) {

            for (int j = 0; j < cnt; j++) {

                int temp = arr[j][j];

                // 상단 arr[0][N-2] = arr[0][N-1]
                for (int i = j + 1; i < M - j; i++) {
                    arr[j][i - 1] = arr[j][i];
                }

                // 우측
                for (int i = j+1; i < N - j; i++) {
                    arr[i-1][M - 1 - j] = arr[i][M - 1 -j];
                }

                // 하단
                for (int i = M - 2 -j; i >= j; i--) {
                    arr[N - 1 - j][i + 1] = arr[N - 1 - j][i];
                }

                // 좌측
                for (int i = N - 2 - j; i >= j; i--) {
                    arr[i+1][j] = arr[i][j];
                }

                arr[j+1][j] = temp;
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                bw.write(arr[i][j] + " ");

            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}