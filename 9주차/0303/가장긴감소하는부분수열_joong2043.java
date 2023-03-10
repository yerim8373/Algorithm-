
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열 A가 주어졌을 때 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성
        // 수열 A 10,30,10,20,20,10 -> 가장 긴 감소하는
        // 부분 수열 30 20 10 길이 3

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] dp = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i<num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;

        for(int i = 0; i < num; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        bw.write(result+"");

        bw.flush();
        br.close();
        bw.close();
    }

}