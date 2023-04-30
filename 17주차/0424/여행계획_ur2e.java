import java.util.Scanner;

public class Q41_여행계획 {
    static int[] parent;
    private static int find(int x){
        if(parent[x] != x){
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        
        if(a > b){
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n];

        // 자기 자신으로 초기화
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(sc.nextInt() == 1){
                    union(i, j);
                }
            }
        }


        String answer = "YES";
        int start = find(sc.nextInt());
        for (int i = 1; i < m; i++) {
            if(start != find(sc.nextInt())){
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }
}
