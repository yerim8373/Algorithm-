import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] isUsed;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[M];
            isUsed = new boolean[N];
            dfs(0);
            System.out.println(sb);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void dfs(int n) {
        if (n == M) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[n] = i + 1;
                dfs(n + 1);
                isUsed[i] = false;
            }
        }

    }
}
