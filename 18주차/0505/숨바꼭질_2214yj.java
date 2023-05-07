package 이코테.최단경로문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p390_숨바꼭질 {
    static ArrayList<Integer>[] map;
    static int[] dist;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        map = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start].add(end);
            map[end].add(start);
        }

        find(1);
        System.out.println(Arrays.toString(dist));
        int min = 2;
        int cnt = 1;
        for(int i = 2; i <= N; i++){
            if(dist[min] < dist[i]) {
                min = i;
                cnt = 1;
            }else if(dist[min] == dist[i]){
                cnt++;
            }
        }
        System.out.println(min +" " + dist[min] + " " + cnt);

    }

    public static void find(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int d : map[start]){
            if(dist[d] == 0 && d != 1){
                dist[d] = dist[start] + 1;
                queue.add(d);
            }
        }
        while(!queue.isEmpty()){
            int last = queue.poll();
            for(int d : map[last]){
                if(dist[d] == 0 && d != 1){
                    dist[d] = dist[last] + 1;
                    queue.add(d);
                }
            }
        }
    }
}
