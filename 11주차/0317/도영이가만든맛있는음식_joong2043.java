
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 재료가 n개 있다. 도영이는 각 재료의 신맛 s와 쓴맛 B를 알고 있다. 여러 재료를 이용해서 요리할 때
        // 그 음식의 신맛은 사용한 재료의 신맛의 곱, 쓴맛은 합이다.
        // 요리의 신맛과 쓴맛의 차이를 작게 만드려고 한다.

        // 1,000,000,000

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        visit = new boolean[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0,1,0);

        bw.write(minVal+"");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int k, int sour, int bit){
        if (k!=0) {
            if (Math.abs(sour - bit) < minVal) {
                minVal = Math.abs(sour - bit);
            }
        }

        for (int i = 0; i < n ; i++){
            if (visit[i] == false){
                visit[i] = true;
                dfs(i+1,sour*arr[i][0], bit+arr[i][1]);
                visit[i] = false;

            }
        }
    }


}