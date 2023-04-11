import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNum = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < testCaseNum; i++){
            int num = Integer.parseInt(br.readLine());

            int[][] arr = new int[num][2];

            for (int j = 0; j < num; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 2; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int max = arr[0][1];
            int cnt = 0;

            for (int j = 0; j < num; j++){
                if (max >= arr[j][1]){
                    max = arr[j][1];
                    cnt++;
                }
            }

            bw.write(cnt+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}