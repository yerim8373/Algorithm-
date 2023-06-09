package BAEKJOON;

import java.io.*;
import java.util.*;

public class gold5_14719_빗물_2 {
	static int result = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < arr.length-1; i++) {
			rain(i);
		}
		
		System.out.println(result);
	}

	private static void rain(int i) {
		int left = 0, right = 0;
		
		// 왼쪽 탐색
		for (int j = 0; j < i; j++) {
			if(arr[i] < arr[j] && left < arr[j]) {
				left = arr[j];
			}
		}
		
		// 오른쪽 탐색
		for (int j = i+1; j < arr.length; j++) {
			if(arr[i] < arr[j] && right < arr[j]) {
				right = arr[j];
			}
		}
		
		if(left == 0 || right == 0) {
			return;
		}
		
		result += Math.min(left, right) - arr[i];
	}

}
