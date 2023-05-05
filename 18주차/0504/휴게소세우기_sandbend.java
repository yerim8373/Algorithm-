.import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 백준 이분탐색

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+2]; // arr : [0, 82, 201, 411, 555, 622, 755, 800]
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n+1] = l;
        Arrays.sort(arr);

        int left = 1;
        int right = l-1;

        while (left < right) {
            int mid = (left+right) / 2;
            int sum =0;

            for (int i=1; i<arr.length; i++) {
                sum += (arr[i]-arr[i-1]-1) / mid;
            }
            if (sum > m)
                left = mid+1;
            else
                right = mid-1;
        }
        bw.write(left+"");

        bw.flush();
        br.close();
        bw.close();
    }
}
