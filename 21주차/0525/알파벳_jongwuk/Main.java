package 알파벳_jongwuk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1}; // dx dy 를 통해 좌표의 상하좌우를 표현
	static boolean[] visited = new boolean[26];
	static int answer = 0;
	static int R = 0, C= 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0,0,0);

		System.out.println(answer);
	}

	private static void dfs(int x, int y, int count) {
		if (visited[map[x][y]]) { //이미 방문한 알파벳이라면,
			answer = Math.max(answer, count);
			return;
		} else {
			visited[map[x][y]] = true;
			for (int i =0; i<4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					dfs(nx,ny,count+1);
				}
			}
			visited[map[x][y]] = false;
		}
	}
}
