import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // min(|Xa-Xb|, |Ya-Yb|, |Za-Zb|)

        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 0; i < N; i++){
            parent[i] = i;
        }

        List<Planet> planetList = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            planetList.add(new Planet(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 간선을 어떻게 만들어야 하나

        edgeList = new ArrayList<>();

//        Collections.sort(planetList);

//        for (int i = 0; i < N; i++){
//            System.out.println(planetList.get(i).x);
//        }

        // x를 기준으로 정렬 후 계산
        Collections.sort(planetList, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x - o2.x;
            }
        });

        for (int i = 0; i < N -1; i++){
            int distance = Math.abs(planetList.get(i).x - planetList.get(i+1).x);

            edgeList.add(new Edge(planetList.get(i).idx,planetList.get(i+1).idx, distance));
        }

        // y를 기준으로 정렬 후 계산
        Collections.sort(planetList, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y - o2.y;
            }
        });

        for (int i = 0; i < N -1; i++){
            int distance = Math.abs(planetList.get(i).y - planetList.get(i+1).y);

            edgeList.add(new Edge(planetList.get(i).idx,planetList.get(i+1).idx, distance));
        }


        // z를 기준으로 정렬 후 계산
        Collections.sort(planetList, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z - o2.z;
            }
        });

        for (int i = 0; i < N -1; i++){
            int distance = Math.abs(planetList.get(i).z - planetList.get(i+1).z);

            edgeList.add(new Edge(planetList.get(i).idx,planetList.get(i+1).idx, distance));
        }


        Collections.sort(edgeList);

        int sum =0;
        for (int i = 0; i < edgeList.size(); i++){
            Edge edge = edgeList.get(i);

            if (find_parent(edge.start) != find_parent(edge.end)){
                sum+= edge.distance;
                union(edge.start, edge.end);
            }
        }

        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);

        if (a < b){
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
    }

    static int find_parent(int num){
        if (parent[num] == num){
            return num;
        }

        return parent[num] = find_parent(parent[num]);
    }
}

class Planet{
    int idx;
    int x;
    int y;
    int z;

    Planet(int idx, int x, int y, int z){
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int distance;

    Edge(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other){
        return this.distance - other.distance;
    }
}