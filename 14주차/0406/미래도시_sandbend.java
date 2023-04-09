import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 최단 경로 문제 _ 플로이드 워셜
    static int INF = (int) 1e9;
    static int[][] graph = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 최단 거리 테이블
        for (int i=0; i<101; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a=0; a<=n; a++) {
            for (int b=0; b<=n; b++) {
                if  (a==b) {
                    graph[a+1][b+a] = 0;
                }
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 플로이드 워셜 알고리즘
        for (int i=1; i<=n; i++) {
            for (int a=1; a<=n; a++) {
                for (int b=1; b<=n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[k][b]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if (distance >= INF) bw.write(-1);
        else bw.write(distance);

        bw.flush();
        br.close();
        bw.close();
    }
}
