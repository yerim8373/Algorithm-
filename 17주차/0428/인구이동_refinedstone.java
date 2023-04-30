import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        while (true) {
            visited = new boolean[N][N];
            if (!movePopulation()) break;
            result++;
        }

        System.out.println(result);
    }

    static boolean movePopulation() {
        boolean isMoved = false;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (visited[x][y]) continue;

                ArrayList<Position> union = new ArrayList<>();
                int totalPopulation = bfs(x, y, union);

                if (union.size() > 1) {
                    isMoved = true;
                    int average = totalPopulation / union.size();
                    for (Position pos : union) {
                        map[pos.x][pos.y] = average;
                    }
                }
            }
        }

        return isMoved;
    }

    static int bfs(int x, int y, ArrayList<Position> union) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = true;

        int totalPopulation = map[x][y];
        union.add(new Position(x, y));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[pos.x][pos.y] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    queue.offer(new Position(nx, ny));
                    visited[nx][ny] = true;

                    totalPopulation += map[nx][ny];
                    union.add(new Position(nx, ny));
                }
            }
        }

        return totalPopulation;
    }
}
