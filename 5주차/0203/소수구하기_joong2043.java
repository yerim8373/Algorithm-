import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int numStart = Integer.parseInt(st.nextToken());
        int numEnd = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[numEnd+1];
        arr[0] = arr[1] = true;

        for(int j =2; j<=Math.sqrt(numEnd); j++) {
            if (arr[j] == false){
                for (int k = j*j; k<=numEnd; k+=j){
                    arr[k] =true;
                }
            }

        }

        for (int i = numStart; i<=numEnd; i++){

            if (arr[i] == false){
                bw.write(i+"\n");
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }

}