import java.io.*;
import java.util.*;

// baekjoon_10162

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        // A 먼저 쭉 소진, 그 다음에 B 소진, 그리고 나머지를 C로 소진

        int[] stove = {300, 60, 10};
        int[] count = {0,0,0};

        for(int i = 0; i<stove.length; i++){
            // num이 stove 원소보다 작아질 때 까지 반복문 실행
            while (num>=stove[i]){
                num-=stove[i];
                count[i]++;
            }
        }

        if(num!=0){
            bw.write(-1+"");
        }
        else{
            bw.write(count[0]+" "+count[1]+" "+count[2]);
        }

        bw.flush();
        br.close();
        bw.close();
    }


}