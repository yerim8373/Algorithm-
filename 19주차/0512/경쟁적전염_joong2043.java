import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static int K;
    static int N;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        while (S --> 0){
            if (arr[X-1][Y-1] != 0){
                break;
            }
            bfs();
        }

        bw.write(arr[X-1][Y-1]+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (arr[i][j] != 0){
                    visit[i][j] = true;
                    pq.offer(new Node(i,j,arr[i][j]));
                }
            }
        }

        while (!pq.isEmpty()){

            Node node = pq.poll();

            for (int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny <0 || nx >= N || ny >= N){
                    continue;
                }

                if (!visit[nx][ny] && arr[nx][ny] == 0){
                    arr[nx][ny] = node.virus;
                    visit[nx][ny] = true;
                }
            }
        }
    }


}

class Node implements Comparable<Node>{
    int x;
    int y;
    int virus;

    Node(int x, int y, int virus){
        this.x = x;
        this.y = y;
        this.virus = virus;
    }

    @Override
    public int compareTo(Node other){
        if (this.virus < other.virus){
            return -1;
        }

        return 1;
    }
}