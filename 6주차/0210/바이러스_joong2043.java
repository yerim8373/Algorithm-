import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static boolean[] visit;
    static int[][] arr;
    static int num;
    static int cnt = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 한 컴퓨터가 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 바이러스에 걸린다

        // 7대의 컴퓨터가 그림과 같이 네트워크 상에 연결
        // 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파
        // 2,3,5,6 네 대의 컴퓨터는 웜바이러스에 걸린다

        // 컴퓨터의 개수
        num = Integer.parseInt(br.readLine());

        arr = new int[num][num];
        visit = new boolean[num];
        // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
        int pairLength = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < pairLength; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            arr[a][b] = 1;
            arr[b][a] = 1;

        }

        // 1번 컴퓨터 부터 탐색 시작
        dfs(0);

        bw.write(cnt+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int n){
        visit[n] = true;
        cnt++;

        for (int i = 0; i<num; i++){
            if (visit[i] == false && arr[i][n] == 1){
                dfs(i);
            }

        }
    }


}