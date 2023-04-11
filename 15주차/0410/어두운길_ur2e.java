import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int x, y;
    int cost;
    Edge(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class Q43_어두운길 {
    static int[] parent;

    private static int find(int x){
        if(parent[x] != x)  {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a > b)   parent[a] = b;
        else        parent[b] = a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Edge[] edges = new Edge[m];
        int sum = 0;
        int max = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(x, y, cost);
            max += cost;
        }

        Arrays.sort(edges, (a, b) -> (a.cost - b.cost));

        for (Edge e : edges) {
            int a = find(e.x);
            int b = find(e.y);

            if(a != b) {
                union(e.x, e.y);
                sum += e.cost;
            }
        }
        System.out.println("max = " + max);
        System.out.println("sum = " + sum);
        System.out.println(max - sum);
    }
}
