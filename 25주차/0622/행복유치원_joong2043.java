
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 조마다 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이만큼 든다.
        // 최대한 비용을 아끼고 싶어 하는 태양이는 k개의 조에 대해 티셔츠 만드는 비용의 합을 최소로 하고 싶어한다.

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sub = new int[n-1];

        // 2 2 1 4
        for (int i = 0 ; i < n -1; i++){
            sub[i] = arr[i+1] - arr[i];
        }

        // 1 2 2 4
        Arrays.sort(sub);

        int total = 0;
        for (int i = 0; i < sub.length - k + 1; i++){
            total+=sub[i];
        }

        bw.write(total+"");

        bw.flush();
        br.close();
        bw.close();

    }


}