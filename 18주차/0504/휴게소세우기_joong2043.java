import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 휴게소를 m개 더 세우려고 한다
        // 다솜이는 이 고속도로를 이용할 때 모든 휴게소를 방문한다.
        // 휴게소를 m개 더 지어서 휴게소가 없는 구간의 길이의 최대값을 최소로 하려고 한다.

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        arr = new int[n+2];
        arr[n+1] = l;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 82 201 411 555 622 755
        // 755 + 82 = 21X
        // 0, 0, 1, 0, 0, 0

        Arrays.sort(arr);

        int answer = binarySearch(1,l-1, m);

        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int start, int end, int extraStoreNum){

        while (start <= end){

            int mid = (start + end) / 2;
            int sum = 0;

            for (int i = 1; i< arr.length; i++){
                sum += (arr[i] - arr[i-1] -1) / mid;
            }

            if (sum <= extraStoreNum) {
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return start;

    }

}