import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for (int i = 1; i <=n ;i++){
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=n; j++){
                int k = Integer.parseInt(st.nextToken());

                if (k ==1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int[] plan = new int[m+1];
        for (int i = 1; i <=m; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }
        boolean isSame = true;

        for (int i = 1; i <= m-1; i++){
            if (parent[plan[i]] != parent[plan[i+1]]){
                isSame = false;
                break;
            }
        }

        if (isSame){
            bw.write("YES\n");
        }
        else{
            bw.write("NO\n");
        }

        bw.close();
        br.close();
    }

    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if (a < b){
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
    }

    public static int findParent(int num){
        if (num == parent[num]){
            return num;
        }

        return parent[num] = findParent(parent[num]);
    }
}