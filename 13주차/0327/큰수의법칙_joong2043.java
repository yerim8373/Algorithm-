
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int total = 0;
        while (m > 0){
            if (count < k) {
                total += arr[num - 1];
                count++;
            }
            else {
                total+=arr[num-2];
                count=0;
            }

            m--;
        }

        bw.write(total+"");

        bw.flush();
        br.close();
        bw.close();
    }



}
