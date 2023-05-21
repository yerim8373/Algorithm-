import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int target = Integer.parseInt(st.nextToken()); // 공유기의 개수
        int[] arr = new int[N];

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int low = 1;
        int high = arr[N - 1] - arr[0];
        int d = 0;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int start = arr[0];
            int count = 1;
            for (int i = 0; i < N; ++i) {
                d = arr[i] - start;

                if (d >= mid) {
                    count++;
                    start = arr[i];
                }
            }

            if(target > count){
                high = mid - 1;
            }
            else {
                ans = mid;
                low = mid + 1;
            }

        }
        bw.write(ans+"");

        bw.flush();
        bw.close();
        br.close();
    }

}
