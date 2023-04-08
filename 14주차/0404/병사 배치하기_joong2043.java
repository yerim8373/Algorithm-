import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 병사배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        int[] dp = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num; i++){
            dp[i] = 1;

            for (int j = 0; j < i; j++){
                if (arr[i] < arr[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }

        Arrays.sort(dp);

        bw.write(num - dp[num-1]+"");

        bw.flush();
        br.close();
        bw.close();
    }
}
