import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int f,s,g,u,d;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String[] str = br.readLine().split(" ");
        f = Integer.parseInt(str[0]); //최고층
        s = Integer.parseInt(str[1]); //현재층
        g = Integer.parseInt(str[2]); //가야할 층
        u = Integer.parseInt(str[3]);; //업
        d = Integer.parseInt(str[4]);; //다운
        visited = new int[f+1];

        System.out.println(bfs(f,s,g,u,d,visited));
    }

    public static String bfs(int f, int s, int g, int u, int d, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1; //시작점 (1층)

        while (!q.isEmpty()) {
            int current = q.poll(); //현재위치
            if (current == g) { //현위치 = 갈층
                return String.valueOf(visited[current] - 1);
            }
            if (current+u <= f) { //현재위치+업 <= 최고층 & 방문 안했으면
                if (visited[current+u] == 0) {
                    visited[current+u] = visited[current] + 1;
                    q.add(current+u);
                }
            }
            if (current-d > 0) { //현재위치-다운 > 0 && 방문 안했으면
                if (visited[current-d] == 0) {
                    visited[current-d] = visited[current] + 1;
                    q.add(current - d);
                }
            }
        }
        return "use the stairs";
    }
}
