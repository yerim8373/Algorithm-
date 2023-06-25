package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class 행복유치원_geonwoo0215 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] arr = new int[n];
		int[] dif = new int[n - 1];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			dif[i] = arr[i + 1] - arr[i];
		}

		Arrays.sort(dif);
		int ans = 0;

		for (int i = 0; i < n - k; i++) {
			ans += dif[i];
		}

		System.out.println(ans);
	}
}
