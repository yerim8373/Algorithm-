import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        // n을 1 2 3 의 합으로 나타내는 방법

        // 3 1 1 1
        // 3 1 2
        // 3 2 1
        // 3 3
        // 4 1 1 1 1
        // 4 1 1 2
        // 4 1 2 1
        // 4 2 1 1
        // 4 2 2
        // 4 1 3
        // 4 3 1

        // 4 = 1+

        // dp[n] = dp[n-3]+dp[n-2]+dp[n-1]

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int i = 0; i<num; i++){
            int sum = Integer.parseInt(br.readLine());
            bw.write(dp[sum]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}