package 이코테.chapter16;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n + 1];
        IntStream.range(1, n + 1).forEach(i -> arr[i] = sc.nextInt());

        //dp
        var dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp, 1);
        }

        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (arr[i] > arr[i - 1])
                    dp[i - 1][j] = dp[i][j] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
            }

        }
        System.out.println(dp[1]);
    }
}
