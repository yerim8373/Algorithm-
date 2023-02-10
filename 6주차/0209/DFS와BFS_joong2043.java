import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static boolean[] visit;
    static int[][] arr;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // n * n 배열
        arr = new int[n][n];
        // visit[n] 배열
        visit = new boolean[n];

        // arr 배열에 값 넣기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            l--;
            w--;
            arr[l][w] = 1;
            arr[w][l] = 1;
        }

        dfs(v);
        visit = new boolean[n];
        System.out.println();
        bfs(v);

    }

    public static void dfs(int n){
        visit[n-1] = true;

        System.out.print(n + " ");

        for (int i = 0; i < visit.length; i++){
            if (!visit[i] && arr[n-1][i] == 1){
                dfs(i+1);
            }

        }
    }

    public static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visit[n-1] = true;

        while (!queue.isEmpty()){
            int num = queue.poll();

            System.out.print(num+" ");

            for(int i =0; i< visit.length; i++) {
                if (!visit[i] && arr[i][num-1] ==1){
                    queue.add(i+1);
                    visit[i] = true;
                }
            }

        }

    }

}