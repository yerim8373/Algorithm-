import java.util.Arrays;
import java.util.Scanner;

public class Test33 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();

        int[] array = new int[n];
        /*0 -> 안먹을때 최대, 1-> 먹을 때  그 전잔 안먹었을때*, 2-> 먹을때 그 전잔도 먹었을때*/
        int[][] dp = new int[3][n+1];

        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextInt();
        }
        /*초기값*/
        dp[0][0] = 0;
        dp[1][0] = array[0];
        dp[2][0] = 0;
        /*로직*/
        for (int i = 1; i <n ; i++) {
            dp[0][i] = Math.max(dp[0][i-1],Math.max(dp[1][i-1],dp[2][i-1]));
            dp[1][i] = dp[0][i-1] + array[i];
            dp[2][i] = dp[1][i-1] + array[i];
        }
        System.out.println(Arrays.stream(new int[]{dp[0][n - 1], dp[1][n - 1], dp[2][n - 1]}).max());
    }
}
