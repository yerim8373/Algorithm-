import java.util.*;

public class virus {
    static int n; // 컴퓨터 수
    static int m; // 간선 수
    static int answer=0;
    static boolean connect[][];
    static boolean visited[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        connect = new boolean[101][101];
        visited = new boolean[101];
        n = scanner.nextInt();
        m = scanner.nextInt();

        for(int i=0;i<m;i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            connect[a][b] = true;
            connect[b][a] = true;
        }
        dfs(1);
        System.out.print(answer);
    }
    private static void dfs(int v) {
        visited[v] = true;

        for(int i=0;i<=n;i++) {
            if(visited[i]==false && connect[v][i]==true){
                dfs(i);
                answer+=1;
            }
        }
    }
}
