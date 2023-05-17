import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 백준 이진탐색

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // [1,2,4,8,9]

        int start = 1;
        int end = arr[n-1]-arr[0];
        int result = 0;

        while (start <= end) {
            int mid = (start+end) / 2;
            int left = arr[0];
            int count = 1;

            for (int i=1; i<n; i++) {
                if (arr[i]-left >= mid) { // 간격
                    count++;
                    left = arr[i];
                }
            }

            if (count >= c) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
