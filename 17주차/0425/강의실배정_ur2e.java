import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        int[][] in = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            in[i][0] = Integer.parseInt(st.nextToken());
            in[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(in, (int[] a, int[] b) -> a[0] == b[0]? a[1]-b[1] : a[0]- b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(in[0][1]);

        for (int i = 1; i < n; i++) {
            if(pq.peek() <= in[i][0]) pq.poll();

            pq.add(in[i][1]);
        }

        System.out.println(pq.size());
    }
}

