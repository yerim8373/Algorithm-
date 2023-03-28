import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    static int[][] move = {{-1,-2}, {-1,2}, {1,2}, {1,-2}, {-2,-1}, {-2,1}, {2,-1}, {2,1}};
    // 경우의 수 x-2 y-1, x-2 y+1, x-1 y+2

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input =br.readLine();

        char x = input.charAt(0);
        char y = input.charAt(1);

        int x1 = x - 'a';

        int y1 = y - '1';

        int num = find(x1,y1);

        bw.write(num+"");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int find(int x, int y){
        int cnt = 0;
        for (int i = 0; i < 8; i++){
            int a = x - move[i][0];
            int b = y - move[i][1];

            if (a < 0 || b < 0 || a >= 8 || b >= 8){
                continue;
            }
            else {
                cnt++;
            }
        }
        return cnt;
    }

}