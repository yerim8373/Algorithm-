package org.example.baekjoon.boj2075;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		//값 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				queue.add(sc.nextInt());
			}
		}

		for (int i = 0; i < N - 1; i++) {
			queue.poll();
		}
		System.out.println(queue.poll());
	}
}
