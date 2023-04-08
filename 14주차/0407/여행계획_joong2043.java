import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1 ; i <= n; i++){
            parent[i] = i;
        }

        for (int i =0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());

                if (num == 1){
                    union(i+1,j+1);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int p = findParent(Integer.parseInt(st.nextToken()));
        boolean answer = true;
        for (int i = 0; i < m-1; i++){
            if (p != findParent(Integer.parseInt(st.nextToken()))){
                answer = false;
                break;
            }
        }

        if (answer){
            bw.write("YES\n");
        }
        else {
            bw.write("NO\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if (a < b){
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
    }

    static int findParent(int num){
        if (parent[num] == num){
            return num;
        }
        return parent[num] = findParent(parent[num]);
    }

}