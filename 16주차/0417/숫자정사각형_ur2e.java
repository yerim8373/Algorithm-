import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[][] board;
    static int n, m;
    private static int bfs(int x, int y){
        Queue<int[]> q  = new LinkedList<>();
        q.offer(new int[]{x, y});
        int L = 1;
        int size = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] tmp = q.poll();
                if(board[x][y] == board[tmp[0]][tmp[1]] && board[x][y] == board[x][tmp[1]] && board[x][y] == board[tmp[0]][y] ){
                    size = Math.max(size, L*L);
                }

                int nx = tmp[0] + 1;
                int ny = tmp[1] + 1;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)  continue;

                q.offer(new int[]{nx, ny});
            }
            L++;
        }
        return size;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
               answer = Math.max(answer, bfs(i, j));
            }
        }

        System.out.println(answer);
    }
}

