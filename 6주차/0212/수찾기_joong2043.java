import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 정수 A[1], A[2], ... , A[N]이 주어졌을때
        // 이 안에 X라는 정수가 존재하는지 알아내는 프로그램 작성

        // 입력 자연수 N
        // 다음 줄 N개의 정수 A[1], A[2], ..., A[N]이 주어진다.
        // 다음 줄에는 M이 주어진다.
        // 다음 줄에는 M개의 수들이 주어지는데 이 수들이 A안에 존재하는지
        // 알아내면 된다.

        // M개의 줄에 답을 출력
        // 존재하면 1, 존재하지 않으면 0을 출력

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<M; i++){
            boolean b = binarySearch(Integer.parseInt(st.nextToken()));
            if (b){
                bw.write(1+"\n");
            }
            else{
                bw.write(0+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean binarySearch(int num){

        int lo = 0;
        int hi = arr.length -1;

        // lo가 hi보다 커지기 전까지 반복한다
        while (lo <= hi){
            int mid = (lo + hi) / 2; // 중간 위치를 구한다.

            // key 값이 중간 위치의 값보다 작을 경우
            if (num < arr[mid]){
                hi = mid - 1;
            }
            // key 값이 중간 위치의 값보다 클 경우
            else if(num > arr[mid]){
                lo = mid + 1;
            }
            // key 값과 중간 위치의 값이 같을 경우
            else{
                return true;
            }

        }
        return false;
    }

}