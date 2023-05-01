import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // -99 -2 -1 4 98
        Arrays.sort(arr);

        // 투포인터 시작
        int start = 0;
        // 투포인터 끝
        int end = n - 1;

        int result = Integer.MAX_VALUE;
        int answerLeft = 0;
        int answerRight = 0;

        while (start < end){
            int diff = Math.abs(arr[end] + arr[start]);

            if (diff < result){
                result = diff;
                answerLeft = start;
                answerRight = end;
            }

            if (arr[end] + arr[start] < 0){
                start++;
            }
            else{
                end--;
            }
        }

        bw.write(arr[answerLeft]+" "+arr[answerRight]);

        bw.flush();
        bw.close();
        br.close();
    }

}