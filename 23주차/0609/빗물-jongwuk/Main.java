import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();

		int[] heights = new int[w];
		for (int i = 0; i < w; i++) {
			heights[i] = sc.nextInt();
		}

		int result = solution(h, w, heights);
		System.out.println(result);
	}

	private static int solution(int h, int w, int[] heights) {
		int result = 0;

		for (int i = 1; i < w - 1; i++) {
			int left = 0;
			int right = 0;

			for (int j = 0; j < i; j++) {
				left = Math.max(heights[j], left);
			}

			for (int j = i + 1; j < w; j++) {
				right = Math.max(heights[j], right);
			}

			if (heights[i] < left && heights[i] < right) {
				result += Math.min(left, right) - heights[i];
			}
		}

		return result;
	}
}
