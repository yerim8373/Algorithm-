package algorithm.backjoon;

import java.io.*;
import java.util.*;

public class 미로탐색 {

  static int N, M;
  static int[][] graph;
  static int[][] dist;
  static boolean[][] visited;

  // 상-하-좌-우 이동
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { 1, -1, 0, 0 };

  static void bfs(int x, int y) {
    Queue<Integer> que = new LinkedList<>();

    que.add(x);
    que.add(y);

    dist[x][y] = 1;
    visited[x][y] = true;

    while(!que.isEmpty()) {
      x = que.poll();
      y = que.poll();

      for(int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
        if(graph[nx][ny] == 0) continue;
        if(visited[nx][ny]) continue;

        que.add(nx);
        que.add(ny);

        visited[nx][ny] = true;
        dist[nx][ny] = dist[x][y] + 1;

      }
    }

  }
  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new int[N + 1][M + 1];
    visited = new boolean[N + 1][M + 1];
    dist = new int[N + 1][M + 1];

    // graph 초기화
    for(int i = 1; i <= N; i++) {
      char[] chars = br.readLine().toCharArray();
      int j = 1;
      for(char c : chars) {
        graph[i][j++] = c - '0';
      }
    }

    // dist 배열 초기화
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        dist[i][j] = -1;
      }
    }
  }
}
