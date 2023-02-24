
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i >= 0; i--){
            if (k==0){
                break;
            }

            while (k >= arr[i]){
                k = k - arr[i];
                count++;
            }

//            if (k>=arr[i]){
//                count += k/arr[i];
//                k = k % arr[i];
//            }
        }

        bw.write(count+"");

        bw.flush();
        br.close();
        bw.close();
    }

}