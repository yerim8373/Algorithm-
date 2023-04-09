public class 미래도시 {
    public static int maxInt = (int) 1e8;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        var dp = new int[n + 1][n + 1];
        IntStream.range(0, n + 1).forEach(j -> Arrays.fill(dp[j], maxInt));
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            dp[a][b] = 1;
            dp[b][a] = 1;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();
//        IntStream.range(1, n + 1).forEach(j -> System.out.println(Arrays.toString(dp[j])));
        // l 중간경로
        // i 시작 , j 도착
        for (int l = 1; l < n + 1; l++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[k][l]);
                }
            }
        }
        int answer = dp[1][k] + dp[k][x];

//        System.out.println(dp[1][x]);
//        IntStream.range(1, n + 1).forEach(j -> System.out.println(Arrays.toString(dp[j])));
        System.out.println(answer > maxInt ? -1 : answer);
    }
}
