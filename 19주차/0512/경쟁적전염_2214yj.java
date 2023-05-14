import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int S, N;
    static ArrayList<Virus> list;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new Virus(i, j, map[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        bfs(0);
        System.out.println(map[X - 1][Y - 1]);

    }

    public static void bfs(int time) {
        if (time == S) {
            return;
        }

        Collections.sort(list);
        ArrayList<Virus> next = new ArrayList<>();
        for(Virus tmp: list){
            for (int i = 0; i < dr.length; i++) {
                int nr = tmp.r + dr[i];
                int nc = tmp.c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == 0) {
                    map[nr][nc] = tmp.num;
                    next.add(new Virus(nr, nc, tmp.num));
                }
            }
        }

        list = next;
        bfs(time + 1);
    }
}

class Virus implements Comparable<Virus> {
    int r;
    int c;
    int num;

    Virus(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }

    public int compareTo(Virus v) {
        return this.num - v.num;
    }
}
