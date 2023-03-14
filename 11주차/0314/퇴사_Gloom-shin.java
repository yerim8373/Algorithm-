import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 세팅
        int N = Integer.parseInt(br.readLine());
        int[] tArr = new int[N+1];
        int[] pArr = new int[N+1];
        int[]dp = new int[N+2]; //최대 수익

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            tArr[i] = Integer.parseInt(st.nextToken());
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0 ; i--) {
            if(N+1 - i < tArr[i]) dp[i] = dp[i+1]; //일을 할 수 없는 경우
            else
                dp[i] = Math.max(dp[i+1], dp[i + tArr[i]] + pArr[i]);
        }

        bw.write(dp[1] + "\n");
        bw.flush();
        bw.close();
    }

}