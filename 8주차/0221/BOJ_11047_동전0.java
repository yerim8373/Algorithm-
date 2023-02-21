package study;

import java.util.Scanner;

public class BOJ_11047_동전0 {
    static int N, K, cnt;
    static int[] coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        coin = new int[N];
        for (int n = 0; n < N; n++) {
            coin[n] = sc.nextInt();
        }

        cnt = 0;
        for (int n = N-1; n >= 0; n--) {
            if (n < 0 || K < coin[n]) continue;
            while (K >= coin[n]) {
                K -= coin[n];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

