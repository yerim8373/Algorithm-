import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표압축_sandbend {

    //백준 정렬 좌표압축

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N]; // 원본 배열
        int[] sorted = new int[N]; // 정렬 할 배열
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            // 정렬할 배열과 원본 배열에 값을 넣어준다
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 수행
        Arrays.sort(sorted);

        // 정렬 된 배열을 순회하면서 map에 넣어준다
        int rank = 0;
        for (int n : sorted) {
            // 원소가 중복되지 않을 때 만
            if (!map.containsKey(n)) {
                map.put(n, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            int ranking = map.get(key); // 원본 배열에 원소에 대한 순위를 갖고온다
            sb.append(ranking).append(' ');
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
