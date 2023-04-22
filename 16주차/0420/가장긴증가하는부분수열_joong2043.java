import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];

        int[] dp = new int[num];
        // 10 20 10 30 20 50
        // 1  2  0  2  2  2
        //    2  0  3  2  3
        //       0  3  2  3
        //          3  2  4
        Arrays.fill(dp,1);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num; i++){
            for (int j = i ; j < num; j++){
                if (arr[i] < arr[j]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }
        Arrays.sort(dp);
        bw.write(dp[num-1]+"");

        bw.flush();
        br.close();
        bw.close();

    }
}
