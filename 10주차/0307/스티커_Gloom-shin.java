package com.example.beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 세팅
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[j][1] = Integer.parseInt(st.nextToken());
            }


            int[][] dp = new int[N][2];
            // N == 1
            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];

            if(N > 2) {
                dp[1][0] = dp[0][1] + arr[1][0];
                dp[1][1] = dp[0][0] + arr[1][1];
            }
            for (int j = 2; j < N; j++) {
                dp[j][0] = Math.max(dp[j-1][1] + arr[j][0] , dp[j-2][1] + arr[j][0]);
                dp[j][1] = Math.max(dp[j-1][0] + arr[j][1] , dp[j-2][0] + arr[j][1]);

            }

            int answer = Math.max(dp[N-1][0],dp[N-1][1]);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
