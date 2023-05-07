import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static final int INF = (int) 1e9;
    static int n, m;
    static int start = 1;
    static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    static int[] d = new int[20001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 술래는 항상 1번 헛간에서 출발한다
        // 전체 맵에는 총 m개의 양방향 통로가 존재

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++){
            list.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b,1));
            list.get(b).add(new Node(a,1));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        int maxNode = 0;
        int maxDistance = 0;

        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            if (maxDistance < d[i]) {
                maxNode = i;
                maxDistance = d[i];
                result.clear();
                result.add(maxNode);
            }
            else if (maxDistance == d[i]) {
                result.add(i);
            }
        }

        bw.write(maxNode + " " + maxDistance + " " + result.size());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        d[start] = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getNum();

            if (d[now] < dist){
                continue;
            }

            for (int i = 0; i < list.get(now).size(); i++){
                int cost = d[now] + list.get(now).get(i).getDistance();

                if (cost < d[list.get(now).get(i).getNum()]){
                    d[list.get(now).get(i).getNum()] = cost;
                    pq.offer(new Node(list.get(now).get(i).getNum(), cost));
                }
            }
        }
    }

}

class Node implements Comparable<Node>{
    private int num;
    private int distance;

    public Node(int num, int distance){
        this.num = num;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNum() {
        return this.num;
    }

    @Override
    public int compareTo(Node other){
        if (this.distance < other.distance){
            return -1;
        }

        return 1;
    }
}