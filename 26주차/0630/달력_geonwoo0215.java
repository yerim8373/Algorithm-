import java.util.Scanner;

public class 달력_geonwoo0215 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[366];
		for (int i = 0; i < n; i++) {
			int s = scanner.nextInt();
			int e = scanner.nextInt();

			for (int j = s; j <= e; j++) {
				arr[j]++;
			}
		}

		int sum = 0;
		int width = 0;
		int height = 0;

		for (int i = 1; i < 366; i++) {
			if (arr[i] == 0) {
				sum += width * height;
				width = 0;
				height = 0;
				continue;
			}
			width++;
			height = Math.max(height, arr[i]);
		}
		sum += width * height;
		System.out.println(sum);

	}
}
