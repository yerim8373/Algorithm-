import java.util.Scanner;

public class Main {

    public static int n, m;
    public static int[] parent = new int[501];

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = sc.nextInt();
                if (x == 1) {
                    unionParent(i, j);
                }
            }
        }

        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }

        int root = findParent(plan[0]);
        for (int i = 1; i < m; i++) {
            if (root != findParent(plan[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
