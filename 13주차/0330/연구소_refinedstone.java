package 이코테.chapter13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/*10시 55분 시작*/
public class 연구소 {
    static int[][] array;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] clone;
    static int n;
    static int m;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        array = new int[n][m];
        clone = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        /*main-logic*/
        dfs(0, 0, 0);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int num) {
        /*조건*/
        if (num == 3) {
            IntStream.range(0, n).forEach(i -> clone[i] = array[i].clone());
            bfs();
            answer = Math.max(answer, maxSafe());
            return;
        }
        /*벽세우기*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = 1;
                    dfs(i, j, num+1);
                    array[i][j] = 0;
//                    num= num -1;
                }
            }
        }
    }

    /*최대 안전지대 구하기*/
    static int maxSafe() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (clone[i][j] == 0) answer++;
            }
        }
        return answer;
    }

    /*전염*/
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (clone[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X >= 0 && Y >= 0 && X < n && Y < m) {
                    if (clone[X][Y] == 0) {
                        clone[X][Y] = 2;
                        q.add(new int[]{X, Y});
                    }
                }
            }
        }
    }
}
