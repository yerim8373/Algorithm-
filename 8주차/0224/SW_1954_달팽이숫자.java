package hw.day02;

import java.util.Scanner;

public class SW_1954_달팽이숫자 {
    static int T, N, d;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            map = new int[N + 2][N + 2];

            //벽치기
            for (int i = 0; i < N + 1; i++) {
                map[0][i] = map[N+1][i]
                = map[i][0] = map[i][N+1] = -1;
            }

            d = 0;
            snail(1, 1, 1);

            //출력
            System.out.println("#" + t);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    //유효한 숫자면 표시하고 다음 유효숫자 찾기
    private static void snail(int x, int y, int cnt) {
        //기저조건
        if (cnt > N*N) return;

        //유도파트
        map[x][y] = cnt;

        int nx = x + dx[d];
        int ny = y + dy[d];
        if (map[nx][ny] == 0) {
            snail(nx, ny, cnt + 1);
        } else {
            d = (d+1)%4; //0이 아니라면 방향 바꾸기
            snail(x + dx[d], y + dy[d], cnt + 1);
        }
    }
}
