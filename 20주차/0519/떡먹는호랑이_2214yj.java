import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int D, K;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[D + 1];
        b = new int[D + 1];


        b[2] = 1;
        a[3] = b[3] = 1;
        for (int i = 4; i <= D; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }


        for (int first = 1; first <= K / 2; first++) {
            if((K  - (first * a[D])) % b[D] == 0) {
                System.out.println(first);
                System.out.println((K  - (first * a[D])) / b[D]);
                return;
            }
        }


    }
}
