package 이코테.chapter14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        long minValue = Long.MAX_VALUE;
        long answerLeft = 0;
        long answerRight = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];
            if(Math.abs(sum) < minValue){
                minValue = Math.abs(sum);
                answerLeft = arr[left];
                answerRight = arr[right];
            }
            // 투 포인터 이동
            if (sum > 0){
                right--;
            }
            else {
                left++;
            }
        }
        System.out.print(answerLeft + " " + answerRight);
    }
}
