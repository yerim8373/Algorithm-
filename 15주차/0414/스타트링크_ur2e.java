import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken()); // 층
        int s = Integer.parseInt(st.nextToken()); // 강호
        int g = Integer.parseInt(st.nextToken()); // 목표
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] visited = new int[f+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = 1;

        int L = 0;
        String answer = "use the stairs";
        while(!q.isEmpty()){
            int n = q.size();

            for(int i = 0; i < n; i++) {
                int curr = q.poll();

                if(curr == g)   answer = String.valueOf(L);

                int nx = curr + u;
                if (nx <= f && visited[nx] == 0) {
                    visited[nx] = 1;
                    q.offer(nx);
                }

                nx = curr - d;
                if (nx > 0 && visited[nx] == 0) {
                    visited[nx] = 1;
                    q.offer(nx);
                }
            }
            L++;
        }
        System.out.println(answer);
    }
}

