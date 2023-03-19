import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[][] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 세팅
        N = Integer.parseInt(br.readLine());

        // 가격의 최소값을 찾자, 꽃잎 3개가 다 들어갈 수 있는 상황을 찾자,
        StringTokenizer st;
        price = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 백트래킹
        boolean[][] visited = new boolean[N][N];
        dfs(0,0, visited);
        System.out.println(min);
    }
    private static void dfs(int count, int sum, boolean[][] visited){
        if(count == 3){
            // 반환
            min = Math.min(sum, min);
            return;
        }
        for (int i = 1; i <N-1 ; i++) {
            for (int j = 1; j <N-1 ; j++) {
                if(!visited[i][j] && check(i,j, visited)){
                    // 꽃심은 영역 표시
                    flowerAdd(i,j,visited);
                    dfs(count+1, sum +sum(i,j), visited);
                    // 꽃심은 영역 다시 제거
                    flowerDelete(i,j,visited);
                }
            }
        }

    }
    private static boolean check(int x, int y, boolean[][] visited){
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(visited[nextX][nextY]){//이미 방문한적 있다면
                return false;
            }
        }
        return true; // 꽃을 심을 수 있음
    }
    private static int sum(int x, int y){
        int cost = price[x][y];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            cost += price[nextX][nextY];
        }
        return cost;
    }

    private static void flowerAdd(int x, int y , boolean[][] visited){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            visited[nextX][nextY] = true;
        }
    }
    private static void flowerDelete(int x, int y , boolean[][] visited){
        visited[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            visited[nextX][nextY] = false;
        }
    }
}