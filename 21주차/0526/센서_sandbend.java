import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 백준 정렬

    static int n;
    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n >= k) {
            bw.write(0);
            return;
        }

        int sum = 0;

        Arrays.sort(arr);

        Integer[] diffArr = new Integer[n-1];
        for (int i=0; i<n-1; i++) {
            diffArr[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(diffArr, Collections.reverseOrder());

        for (int i=k-1; i<n-1; i++) {
            sum = diffArr[i];
        }

        bw.write(sum+"");

        bw.flush();
        br.close();
        bw.close();

    }
}
