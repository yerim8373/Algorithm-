import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[][] graph;
    static boolean[] visit;
    static int v,e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new int[v+1][v+1];

        for (int i = 1; i <= v; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i<= v; i++){
            for (int j =1; j <= v; j++){
                if (i==j){
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= v; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
        }

        for (int i = 1; i <= v ; i++){
            for (int a =1; a<= v; a++){
                for (int b=1; b<=v; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        int answer = 0;
        for (int i =1; i<=v; i++){
            int cnt = 0;
            for (int j =1; j<=v; j++){
                if (graph[i][j] != Integer.MAX_VALUE || graph[j][i] !=Integer.MAX_VALUE){
                    cnt++;
                }
            }

            if (cnt == v){
                answer++;
            }
        }

        bw.write(answer+"");

        bw.flush();
        br.close();
        bw.close();

    }

}
