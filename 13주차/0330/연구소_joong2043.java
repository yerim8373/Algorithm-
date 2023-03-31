
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[][] arr;
    static int[][] wallArr;
    static int[][] tempArr;
    static int a;
    static int b;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int maxNum = 0;

    public static void main(String[] args) throws Exception{
//        long sTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new int[a][b];
        wallArr = new int[a][b];
        tempArr = new int[a][b];

        for (int i = 0; i < a; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < a; i++) {
            wallArr[i] = arr[i].clone();
        }

        makeWall(0);

        bw.write(maxNum+"");

        br.close();
        bw.flush();
        bw.close();

    }

    // 벽 3개를 만드는 DFS 메서드
    public static void makeWall(int cnt){

        if (cnt == 3){
            bfs();
            checkZeroNumbers();
            return;
        }

        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                if (wallArr[i][j] == 0) {
                    wallArr[i][j] = 1;
                    makeWall(cnt+1);
                    wallArr[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 감염 여부를 확인하는 BFS 메서드
    public static void bfs(){

        Queue<Lab> queue = new LinkedList<>();

        for (int i = 0; i < a; i++) {
            tempArr[i] = wallArr[i].clone();
        }

        for (int i = 0 ; i < a; i++){
            for (int j = 0; j < b; j++){
                if (tempArr[i][j] ==2){
                    queue.add(new Lab(i,j));
                }
            }
        }

        while (!queue.isEmpty()){
            Lab lab = queue.poll();

            for (int k = 0 ; k < 4; k++){
                int nx = lab.x + dx[k];
                int ny = lab.y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < a && ny < b){
                    if (tempArr[nx][ny] == 0){
                        tempArr[nx][ny] = 2;
                        queue.add(new Lab(nx,ny));
                    }
                }
            }
        }

    }

    // 0의 개수가 몇 개인지 확인하는 메서드
    public static void checkZeroNumbers(){
        int cnt = 0;

        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                if (tempArr[i][j] == 0){
                    cnt++;
                }
            }
        }
        maxNum = Math.max(maxNum, cnt);
    }

}

class Lab{
    int x;
    int y;

    public Lab(int x,int y){
        this.x = x;
        this.y = y;
    }
}
