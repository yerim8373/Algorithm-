import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[] used;
	static boolean[][] visit;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int count = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		used = new boolean[26];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		dfs(new Point(0, 0, map[0][0], 1));
		System.out.println(count);
	}

	private static void dfs(Point point) {
		//check-in
		visit[point.x][point.y] = true;
		used[point.c - 'A'] = true;

		//인접 배열 탐색
		for (int i = 0; i < 4; i++) {
			int nx = point.x + dx[i];
			int ny = point.y + dy[i];

			//map 범위 내에서 미방문 지역인 경우
			if (isIn(nx, ny) && !visit[nx][ny]) {
				char nextChar = map[nx][ny];

				//해당 알파벳이 처음인 경우 dfs 탐색을 계속 진행한다.
				if (!used[nextChar - 'A']) {
					dfs(new Point(nx, ny, nextChar, point.count + 1));
				}
			}
		}

		//check-out
		visit[point.x][point.y] = false;
		used[point.c - 'A'] = false;

		count = Math.max(count, point.count);
	}

	private static boolean isIn(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	static class Point{
		int x;
		int y;
		char c;
		int count;

		public Point(int x, int y, char c, int count) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.count = count;
		}
	}
}
