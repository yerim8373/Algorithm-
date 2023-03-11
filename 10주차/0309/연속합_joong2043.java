
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//      n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
//
//      예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];

        for (int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[0] = 10
        // dp[1] = max(10 - 4, -4)
        // dp[2] = max(10 - 4 + 3, -4 + 3, 3)
        // dp[3] = max(10 - 4 + 3 + 1, -4 + 3 + 1, 3 + 1, 1)

        int[] dp = new int[num];
        dp[0] = arr[0];

        for (int i = 1 ; i < num; i++) {
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
        }

        Arrays.sort(dp);

        bw.write(dp[num-1]+"");

        bw.flush();
        br.close();
        bw.close();
    }

}