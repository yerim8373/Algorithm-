import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그림_geonwoo0215 {

	static int n;
	static int m;
	static int map[][];
	static boolean visited[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		map = new int[n][m];
		visited = new boolean[n][m];


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = scanner.nextInt();
			}
		}

		int cnt = 0;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}

		System.out.println(cnt);
		System.out.println(ans);

	}

	public static int bfs(int x, int y) {
		int ans = 1;
		visited[x][y] = true;

		Queue<int[]> q = new LinkedList();
		q.add(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int curX = poll[0];
			int curY = poll[1];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}
				if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					q.add(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
					ans++;
				}
			}
		}
		return ans;

	}
}
