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

        // 모든 여행 계획지의 parent 값이 동일한 지 확인하기
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

    // union 합집합 만들기
    static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        // parent의 값은 작은 값을 일반적으로 넣기 때문에 크기 비교 후 작은 값으로 넣는다.
        if (a < b){
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
    }

    // parent 값을 재귀 함수를 통해서 찾기
    static int findParent(int num){
        if (parent[num] == num){
            return num;
        }
        return parent[num] = findParent(parent[num]);
    }

}