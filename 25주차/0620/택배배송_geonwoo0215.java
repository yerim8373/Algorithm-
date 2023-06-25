package BAEKJOON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 택배배송_geonwoo0215 {

	static class Node implements Comparable<Node> {
		int idx;
		int dist;

		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}

		public int compareTo(Node node) {
			return Integer.compare(this.dist, node.dist);
		}
	}

	static	int n;
	static	int m;
	static 	int[] distances;
	static 	List<List<Node>> graph = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		distances = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[1] = 0;
		dijkstra();
		System.out.println(distances[n]);
	}

	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int current = currentNode.idx;
			int distance = currentNode.dist;

			if (distances[current] < distance) {
				continue;
			}

			for (Node nextNode : graph.get(current)) {
				int next = nextNode.idx;
				int nextDistance = distance + nextNode.dist;

				if (nextDistance < distances[next]) {
					distances[next] = nextDistance;
					pq.offer(new Node(next, nextDistance));
				}
			}
		}

	}
}
