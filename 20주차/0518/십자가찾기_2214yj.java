import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static ArrayList<Cross> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                if (str[j - 1].equals("*")) {
                    visited[i][j] = true;
                }
            }
        }

        result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j])
                    checkCross(i, j, 1);
            }
        }

        boolean isAvailabe = true;
        for (Cross c : result) {
            visited[c.x][c.y] = false;
            visited[c.x + c.s][c.y] = false;
            visited[c.x][c.y + c.s] = false;
            visited[c.x - c.s][c.y] = false;
            visited[c.x][c.y - c.s] = false;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j]) isAvailabe = false;
            }
        }

        if (isAvailabe) {
            StringBuilder sb = new StringBuilder();
            sb.append(result.size()).append("\n");
            for (Cross c : result) {
                sb.append(String.format("%d %d %d\n", c.x, c.y, c.s));
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

    }

    public static void checkCross(int x, int y, int s) {
        // x,y를 중심으로 갖는 s 사이즈의 십자가가 맞는지 확인
        boolean isRight = true;
        for (int i = 1; i <= s; i++) {
            if (x - i <= 0 || x + i >= visited.length || y - i <= 0 || y + i >= visited[0].length) {
                isRight = false;
                break;
            }
            if (!visited[x + i][y] || !visited[x][y + i] || !visited[x - i][y] || !visited[x][y - i]) {
                isRight = false;
                break;
            }
        }
        if (isRight) {
            result.add(new Cross(x, y, s));
            checkCross(x, y, s + 1);
        }
    }

}

class Cross {
    int x, y, s;

    Cross(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}
