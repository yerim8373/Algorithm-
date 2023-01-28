import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        int fibonacci(int n) {
//            if (n == 0) {
//                printf("0");
//                return 0;
//            } else if (n == 1) {
//                printf("1");
//                return 1;
//            } else {
//                return fibonacci(n‐1) + fibonacci(n‐2);
//            }
//        }

        int num = Integer.parseInt(br.readLine());

        // dp[i][0] -> 0이 몇 개 나오는지 입력
        // dp[i][1] -> 1이 몇 개 나오는지 입력
        int[][] dp = new int[41][2];

        dp[0][0] = 1; // fibonacci(0)
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i<41; i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }

        for (int i = 0; i < num; i++){
            int n = Integer.parseInt(br.readLine());

            bw.write(dp[n][0]+" "+dp[n][1]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}