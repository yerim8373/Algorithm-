import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // 백준 dfs
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[] cheack = new boolean[26];
    static int[][] map;
    static int answer = 0;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 세로
        c = Integer.parseInt(st.nextToken()); // 가로

        map = new int[r][c]; // 2x4

        for (int i=0; i<r; i++) {
            String str = br.readLine();
            for (int j=0; j<c; j++) {
                map[i][j] = str.charAt(j)-'A';
            }
        }

        dfs(0,0,0);

        bw.write(answer+"");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int x, int y, int count) {
        if (cheack[map[x][y]]) {
            answer = Math.max(answer, count);
            return;
        } else {
            cheack[map[x][y]] = true;
            for (int i=0; i<4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (cx>=0 & cy>=0 & cx<r & cy<c) {
                    dfs(cx, cy, count+1);
                }
            }
            cheack[map[x][y]] = false;
        }
    }
}
