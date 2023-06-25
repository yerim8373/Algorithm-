
import java.io.*;
import java.util.*;

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        ArrayList<Point> a;
        ArrayList<ArrayList<Integer>> graph;
        StringBuilder sb = new StringBuilder();

        for (int q = 0; q < t; q++) {
            int n = Integer.parseInt(br.readLine());

            // Point 객체를 가지는 리스트 생성
            a = new ArrayList<>();

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                a.add(new Point(x,y));
            }

            graph = new ArrayList<>();

            for (int i = 0; i < n + 2; i++){
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++){
                for (int j = i + 1; j < n +2; j++){
                    if (distance(a.get(i), a.get(j)) <= 1000){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            sb.append((BFS(graph, n) ? "happy" : "sad") + "\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();

    }

    public static int distance(Point p1, Point p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N){
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);

        boolean[] visited = new boolean[N+2];
        visited[0] = true;

        while (!q.isEmpty()){
            int now = q.poll();

            if (now == N + 1){
                return true;
            }

            for (int next : graph.get(now)){
                if (!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return false;
    }

}