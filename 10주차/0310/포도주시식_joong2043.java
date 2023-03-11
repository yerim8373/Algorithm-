
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 6, 10, 13, 9, 8, 1
        //  7 300 200 400 300 200 1
        // dp[0] = arr[0]
        // dp[1] = arr[1], arr[0] + arr[1]
        // dp[2] = arr[0] + arr[2], arr[1] + arr[2]
        // dp[3] = dp[1] + arr[3], dp[2] + arr[3]
        // dp[n] = dp[n-2] + arr[n], dp[n-3] + arr[n-1] + arr[n]


        if (n >= 1) {
            dp[0] = arr[0];
        }

        if (n >=2) {
            dp[1] = Math.max(arr[1], arr[0] + arr[1]);
        }

        if (n > 2) {

            dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]), dp[i - 1]);
            }
        }

        bw.write(dp[n-1]+"");

        bw.flush();
        br.close();
        bw.close();
    }

}