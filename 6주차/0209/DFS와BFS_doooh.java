package algorithm.backjoon;

import java.io.*;
import java.util.*;

public class DFS와DFS {
  static int N, M, V;
  static StringBuilder sb = new StringBuilder();

  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 정점의 개수
    M = Integer.parseInt(st.nextToken()); // 간선의 개수
    V = Integer.parseInt(st.nextToken()); // 탐색 시작 위치

    graph = new ArrayList[N + 1];

    for(int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for(int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int V1 = Integer.parseInt(st.nextToken()), V2 = Integer.parseInt(st.nextToken());

      graph[V1].add(V2);
      graph[V2].add(V1);
    }

    for(int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }
  }

  static void dfs(int x) {
    visited[x] = true;
    sb.append(x).append(' ');

    for(int y : graph[x]) {
      if(visited[y]) continue;
      dfs(y);
    }
  }

  static void bfs(int x) {
    Queue<Integer> que = new LinkedList<>();

    que.add(x);
    visited[x] = true;

    while(!que.isEmpty()) {
      int poll = que.poll();
      sb.append(poll).append(' ');

      for(int y : graph[poll]) {
        if(visited[y]) continue;

        que.add(y);
        visited[y] = true;
      }
    }
  }

  static void removeBuffer() {
    visited = new boolean[N + 1];
    for(int i = 1; i <= N; i++) {
      visited[i] = false;
    }
  }
  public static void main(String[] args) throws IOException {
    input();

    removeBuffer();
    dfs(V);
    sb.append('\n');

    removeBuffer();
    bfs(V);
    sb.append('\n');

    System.out.println(sb);
  }
}
