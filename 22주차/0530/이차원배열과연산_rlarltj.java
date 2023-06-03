import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int x, y, k;
	static int xLength;
	static int yLength;
	static int[][] board = new int[101][101];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());


		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		xLength = 3;
		yLength = 3;

		/**
		 * 예를 들어, [3, 1, 1]에는 3이 1번, 1가 2번 등장한다.
		 * 따라서, 정렬된 결과는 [3, 1, 1, 2]가 된다.
		 * 다시 이 배열에는 3이 1번, 1이 2번, 2가 1번 등장한다.
		 * 다시 정렬하면 [2, 1, 3, 1, 1, 2]가 된다.
		 */

		/**
		 * 행의 개수 >= 열의 개수인 경우 열의 개수를 늘린다.
		 * 행의 개수 < 열의 개수인 경우 행의 개수를 늘린다.
		 */

		System.out.println(solve());
	}

	private static int solve() {
		for (int i = 0; i <= 100; i++) {
			if (board[x - 1][y - 1] == k) {
				return i;
			}

			operate();
		}

		return -1;
	}

	private static void operate() {
		//x 길이와 y 길이를 비교한다.
		//이후 R, C를 실행
		if (xLength >= yLength) {
			operateR();
		}else {
			operateC();
		}
	}

	private static void operateC() {
		//세로로 늘리는 연산
		PriorityQueue<Number> pq = new PriorityQueue<>();

		Map<Integer, Integer> map;
		int maxLength = 0;

		for (int i = 0; i < yLength; i++) {

			map = new HashMap<>();
			for (int j = 0; j < xLength; j++) {
				if (board[j][i] != 0) {
					map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
				}
			}

			maxLength = Math.max(maxLength, map.keySet().size() * 2);

			for (int key : map.keySet()) {
				pq.offer(new Number(key, map.get(key)));
			}

			int idx = 0;

			while (!pq.isEmpty()) {
				Number num = pq.poll();
				board[idx ++][i] = num.value;
				board[idx ++][i] = num.count;
			}

			while (idx <= 100) {
				board[idx++][i] = 0;
			}
		}

		xLength = maxLength;
	}

	private static void operateR() {
		//가로로 늘리는 연산

		PriorityQueue<Number> pq = new PriorityQueue<>();

		Map<Integer, Integer> map;
		int maxLength = 0;

		for (int i = 0; i < xLength; i++) {

			map = new HashMap<>();
			for (int j = 0; j < yLength; j++) {
				if(board[i][j] != 0)
					map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
			}

			//value와 개수가 저장된 map을 이용해 정렬

			maxLength = Math.max(maxLength, map.keySet().size() * 2);

			for (int key : map.keySet()) {
				pq.offer(new Number(key, map.get(key)));
			}

			int idx = 0;

			while (!pq.isEmpty()) {
				Number num = pq.poll();

				board[i][idx ++] = num.value;
				board[i][idx ++] = num.count;
			}

			while (idx <= 100) {
				board[i][idx++] = 0;
			}
		}

		yLength = maxLength;
	}

	static class Number implements Comparable<Number>{
		int value;
		int count;

		public Number(int value, int count) {
			this.value = value;
			this.count = count;
		}

		@Override
		public int compareTo(Number o) {
			if (this.count == o.count) {
				return this.value - o.value;
			}

			return this.count - o.count;
		}
	}

}
