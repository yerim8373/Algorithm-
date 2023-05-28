import java.io.*;
import java.util.*;

public class 알파벳_yerim {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, result = 0;
	static char[][] map;
	static boolean[] alphabet = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int r = 0; r < map.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		alphabet[map[0][0] - 'A'] = true;
		dfs(new Node(0, 0, 1));
		
		System.out.println(result);
	}

	private static void dfs(Node node) {

		result = Math.max(result, node.cnt);
		
		for (int d = 0; d < dr.length; d++) {
			int nr = node.r + dr[d];
			int nc = node.c + dc[d];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(!alphabet[map[nr][nc] - 'A']) {
					alphabet[map[nr][nc] - 'A'] = true;
					dfs(new Node(nr, nc, node.cnt+1));
					alphabet[map[nr][nc] - 'A'] = false;
				}
			}
		}
	}

	static class Node{
		int r, c, cnt;
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
