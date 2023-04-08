import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 그래프 이론 문제 _ 서로소 집합 알고리즘
    static int[] parent = new int[501];
    static ArrayList<Integer> plan = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        // 부모는 자기자신으로 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 연산을 각각 수행
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());

                // 연결된 부분을 합집합 연산
                if (x == 1) {
                    unionParent(i + 1, j + 1);
                }
            }
        }

        // 여행계획 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int x = Integer.parseInt(st.nextToken());
            plan.add(x);
        }

        for (int i=0; i<m-1; i++) {
            if (findParent(plan.get(i)) == findParent(plan.get(i+1))) {
                bw.write("YES");
                bw.flush();
                br.close();
                bw.close();
                return;
            } else {
                bw.write("NO");
                bw.flush();
                br.close();
                bw.close();
                return;
            }
        }

    }

    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a != b){
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }
}