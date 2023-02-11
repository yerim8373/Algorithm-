import java.util.*;
import java.io.*;
public class Main {
    private static int GCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while(min != 0){
            int temp = max % min;
            max = min;
            min = temp;
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int[] gap = new int[n-1];

        for (int i=1;i<n;i++){
            int x = scanner.nextInt();
            gap[i-1] = x-num;
            num = x;
        }

        int a = gap[0];
        for (int i=1;i<n-1;i++) {
            a = GCD(a, gap[i]);
        }

        int answer = 0;
        for (int i=0;i<n-1;i++) {
            answer += gap[i]/a -1;
        }
        System.out.println(answer);
    }

}