import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Integer[] dist = new Integer[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N - 1; i++){
            dist[i] = arr[i+1] - arr[i];
        }

        // 2 3 0 1 2

        // 3 1 1 2 2 2 1 3 2

        Arrays.sort(dist, Collections.reverseOrder());

        int sum = 0;
        for (int i = K - 1; i < N - 1; i++){
            sum += dist[i];
        }

        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();
    }


}