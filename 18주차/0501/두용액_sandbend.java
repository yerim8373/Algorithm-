import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 백준 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int tmp = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        while (left < right) {

            // 두 원소의 차이 양수화
            int dis = Math.abs(arr[left] + arr[right]);

            if (dis < tmp) {
                tmp = dis;
                answer1 = arr[left];
                answer2 = arr[right];
            }
            if (arr[left] + arr[right] > 0)
                right--;
            else
                left++;
        }

        bw.write(answer1 + " " + answer2);

        bw.flush();
        br.close();
        br.close();
    }

}