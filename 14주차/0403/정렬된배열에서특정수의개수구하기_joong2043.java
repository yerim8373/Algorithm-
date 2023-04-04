import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[num];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = binarySearch(n,0,arr.length-1);

        if (answer == 0){
            bw.write(-1+"");
        }
        else {
            bw.write(answer + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int binarySearch(int key, int low, int high){
        int mid;

        if (low <= high){
            mid = (low + high) / 2;

            if (key == arr[mid]){
                cnt++;
                binarySearch(key, mid+1,high);
                binarySearch(key, low, mid-1);
            }
            else if (key < arr[mid]) {
                binarySearch(key, low, mid-1);
            }
            else{
                binarySearch(key, mid+1, high);
            }
        }

        return cnt;
    }

}