
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 그리디의 핵심 -> 정렬 잘 하기
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

//        1, 4
//        3, 5
//        0, 6
//        5, 7
//        3, 8
//        5, 9
//        6, 10
//        8, 11
//        8, 12
//        2, 13
//        12, 14

        int end = arr[0][1];
        int count = 1;

        for (int i = 1; i < num; i++){
            if (arr[i][0] >= end){
                count++;
                end = arr[i][1];
            }
        }

        bw.write(count+"");

        bw.flush();
        br.close();
        bw.close();
    }

}