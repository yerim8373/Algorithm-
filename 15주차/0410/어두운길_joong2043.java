import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[] parent;
    static ArrayList<Edge> edgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for (int i = 1 ; i <= n; i++){
            parent[i] = i;
        }

        int sum = 0;
        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());

            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            sum+=price;
            edgeList.add(new Edge(price,nodeA,nodeB));
        }

        Collections.sort(edgeList);

        int result = 0;

        for (int i = 0 ; i < m ; i++){
            int price = edgeList.get(i).getDistance();
            int nodeA = edgeList.get(i).getNodeA();
            int nodeB = edgeList.get(i).getNodeB();

            // 사이클 형성 여부를 확인
            if (findParent(nodeA) != findParent(nodeB)){
                union(nodeA,nodeB);
                result += price;
            }
        }

        bw.write(sum - result+"");

        bw.flush();
        br.close();
        bw.close();
    }

    static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if (a < b){
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
    }

    static int findParent(int num){
        if (parent[num] == num){
            return num;
        }
        return parent[num] = findParent(parent[num]);
    }

}

class Edge implements Comparable<Edge>{
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB){
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance(){
        return this.distance;
    }

    public int getNodeA(){
        return this.nodeA;
    }

    public int getNodeB(){
        return this.nodeB;
    }
    // 거리가 짧은 게 우선순위
    @Override
    public int compareTo(Edge o) {
        if (this.distance < o.distance){
            return -1;
        }
        return 1;
    }
}