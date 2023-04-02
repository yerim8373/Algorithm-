import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        int len = num.length() / 2; // 8 -> 4
        int sum1 = 0; int sum2 = 0;
        for (int i = 0; i < num.length(); i++){
            if (i < len){
                sum1 += num.charAt(i) - '0';
            }
            else{
                sum2 += num.charAt(i) - '0';
            }
        }

        if (sum1 == sum2){
            bw.write("LUCKY");
        }
        else{
            bw.write("READY");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}