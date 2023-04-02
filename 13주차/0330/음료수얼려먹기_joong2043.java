
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int maxNum = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        arr = new int[a][b];
        int cnt = 0;

        for (int i = 0; i < a; i++){
            String str = br.readLine();
            for (int j = 0; j < b; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                if (arr[i][j] == '0'){
                    dfs();
                    cnt++;
                }

            }
        }

        bw.write(cnt+"");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(x,y){

        for (int i =0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length){
                continue;
            }

            if (arr[nx][ny] == '0'){
                arr[nx][ny] == '1';
                dfs(nx,ny);
            }
        }
    }

}

