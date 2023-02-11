import java.util.*;

public class DFS_BFS {
    static int n,m,v;
    static boolean[][] connect;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        v = scanner.nextInt();

        connect = new boolean[1001][1001];
        visited = new boolean[1001];

        for(int i=0;i<m;i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            connect[a][b] = true;
            connect[b][a] = true;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[1001];
        bfs();
    }

    public static void dfs(int a){
        visited[a] = true;
        System.out.print(a+" ");

        for(int i=1;i<=n;i++){
            if(visited[i]==false && connect[a][i]==true) {
                dfs(i);
            }
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v]=true;

        System.out.print(v+" ");

        while(!queue.isEmpty()){
            int a = queue.poll();

            for(int i=1;i<=n;i++){
                if(connect[a][i]==true && visited[i]==false){
                    queue.offer(i);
                    visited[i]=true;
                    System.out.print(i+" ");
                }
            }

        }
    }
}
