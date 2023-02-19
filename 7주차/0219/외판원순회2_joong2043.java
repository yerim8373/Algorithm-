
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    static int num;
    static int[][] arr;
    static boolean[] visit;
    static int cost;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // 1번부터 N번까지 번호가 매겨져 있는 도시들, 도시들 사이에 길이 있다
        // 이제 한 외판원이 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐
        // 다시 원래의 도시로 돌아오는 순회 여행 경로 계획
        // 단 한 번 갔던 도시로는 다시 갈 수 없다

        // 도시의 수
        num = Integer.parseInt(br.readLine());

        arr = new int[num][num];

        cost = Integer.MAX_VALUE;
        visit = new boolean[num];

        // 다음 N개의 줄에는 비용 행렬이 주어짐
        for (int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<num; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < num; i++){
            visit[i] = true;
            dfs(i,i,0,0);

        }

        bw.write(cost+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int start, int now, int sum, int depth){
        if (depth == num - 1){
            if (arr[now][start] != 0){
                sum += arr[now][start];
                cost = Math.min(cost, sum);
            }
            return;
        }

        for (int i = 0; i < num; i++){
            if (!visit[i] && arr[now][i] != 0){
                visit[i] = true;
                dfs(start, i,sum+arr[now][i],depth+1);
                visit[i] = false;
            }
        }

    }

}