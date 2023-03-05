import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test30 {
    static int[] array;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            /*최소 1개는 만족하므로*/
            dp[i] = 1;
        }
        /*dp[i] -> i번째 원소를 마지막으로 하는 가장 긴 감소하는 부분 수열의 길이*/
        /*10 30 10 20 20 10*/
        function();
        /*최대값*/
        System.out.println(Arrays.stream(dp).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(0));
    }

    static void function() {
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j <i ; j++) {
                /*기존 dp[j]까지의 최대수열길이를 저장*/
                if(array[i] <array[j]){
                    /*기존 dp[j]의 최대수열길이에서 array값이 더 작아졌으므로 dp[j]+1을 해준다*/
                    /*Math.max는 안전장치*/
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
    }
}
