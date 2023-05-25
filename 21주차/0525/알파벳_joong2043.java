import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int maxNum = Integer.MIN_VALUE;
    static HashSet<Character> hSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++){
            String str = br.readLine();

            for (int j = 0; j < C; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        // 해시셋에 좌측 상단 문자 입력
        hSet.add(arr[0][0]);

        // dfs 시작
        dfs(new Node(0,0,1));

        bw.write(maxNum+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(Node node){

        if (node.cnt > maxNum){
            maxNum = node.cnt;
        }

        for (int i = 0; i < 4; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            if (!visit[nx][ny]) {
                if (!hSet.contains(arr[nx][ny])) {
                    hSet.add(arr[nx][ny]);
                    visit[nx][ny] = true;
                    dfs(new Node(nx,ny, node.cnt + 1));
                    visit[nx][ny] = false;
                    hSet.remove(arr[nx][ny]);
                }
            }

        }
    }

}
class Node{
    int x;
    int y;
    int cnt;

    Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}