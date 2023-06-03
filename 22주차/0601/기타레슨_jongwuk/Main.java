package org.example.baekjoon.boj2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] sArr = br.readLine().split(" ");
		int N = Integer.parseInt(sArr[0]);
		int M = Integer.parseInt(sArr[1]);
		int[] lesson = new int[N];

		int sum = 0;
		int max = 0;
		int low = 0, high = 0;
		sArr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(sArr[i]);
			sum += lesson[i];
			low = Math.max(low, lesson[i]);
		}

		high = sum;
		binSearch(low, high, M, N, lesson);
		System.out.println(low);

	}

	private static void binSearch(int low, int high, int m, int n, int[] lesson) {
		int mid, sum, count;

		while (low <= high) {
			mid = (low + high) / 2;
			sum = 0;
			count = 0;

			for (int i = 0; i < n; i++) {
				if (sum + lesson[i] > mid) {
					sum = 0;
					count++;
				}

				sum += lesson[i];
			}

			if (sum > 0) {
				count++;
			}

			if (count <= m) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
	}
}
