import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int num;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        arr = new char[num][num];
        visit = new boolean[num][num];

        for (int i = 0 ; i < num; i++){
            String str = br.readLine();
            for (int j = 0; j < num; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < num; i++){
            for (int j = 0; j < num; j++){
                if (arr[i][j] == '1' && !visit[i][j]){
                    int n = bfs(i,j,1);
                    list.add(n);
                }
            }
        }

        bw.write(list.size()+"\n");
        Collections.sort(list);

        int len = list.size();
        for (int i = 0; i < len; i++){
            bw.write(list.get(i)+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int bfs(int x, int y, int cnt){
        Queue<Apart> queue = new LinkedList<>();

        queue.add(new Apart(x,y));
        visit[x][y] = true;

        while (!queue.isEmpty()){

            Apart apart =queue.poll();

            for (int i = 0; i < 4; i++){
                int nx = apart.x + dx[i];
                int ny = apart.y + dy[i];

                if (nx < 0 || ny < 0 || nx >=num || ny>=num){
                    continue;
                }

                if (!visit[nx][ny] && arr[nx][ny]=='1'){
                    visit[nx][ny] = true;
                    queue.add(new Apart(nx,ny));
                    cnt++;
                }
            }
        }

        return cnt;
    }

}

class Apart{
    int x;
    int y;

    Apart(int x, int y){
        this.x = x;
        this.y = y;
    }
}