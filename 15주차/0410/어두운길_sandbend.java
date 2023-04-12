import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }
    public int getDistance() {
        return distance;
    }
    public int getNodeA() {
        return nodeA;
    }
    public int getNodeB() {
        return nodeB;
    }

    // 거리가 짧은 것기 높은 우선순쉬를 갖도록
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
public class p397_어두운길 {
    // 그래프 이론 _ 크루스칼 알고리즘

    // 노드의 개수와 간선의 개수
    public static int n, m;
    public static int[] parent = new int[200001]; // 부모 테이블 초기화하기
    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 부모를 자기 자신으로 초기화
        for (int i=0; i<=n; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            edges.add(new Edge(z, x, y));
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges);
        int total = 0; // 전체 가로등 비용

        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            total += cost;
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }
        System.out.println(total - result);
    }
}
