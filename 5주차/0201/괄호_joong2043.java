import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i<num; i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            char[] charArr = str.toCharArray();
            stack.push(charArr[0]);
//            stack.push(charArr[1]);
            for(int j = 1; j < charArr.length; j++){
                if (!stack.isEmpty() && stack.peek() == '(' && charArr[j] == ')'){
                    stack.pop();
                }
                else {
                    stack.push(charArr[j]);
                }
            }
            if (stack.isEmpty()){
                bw.write("YES\n");
            }
            else{
                bw.write("NO\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

}