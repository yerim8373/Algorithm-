import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] visit;
    static int[][] arr;
    static ArrayList<Square> list;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n, l , r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // n * n 크기의 땅 각 땅에는 나라가 하나씩 존재, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다.
        // 인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1*1 크기이기 때문에 모든 국경선은 정사각형 형태

        // 인구 이동은 하루동안 다음과 같이 진행

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true){
            visit = new boolean[n][n];
            boolean isMove = false;

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (!visit[i][j]){
                        int total = bfs(i,j);

                        if (list.size() > 1) {
                            changePeopleNum(total);
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove){
                break;
            }
            else{
                result++;
            }
        }

        bw.write(result+"");

        bw.close();
        br.close();
    }

    public static int bfs(int x, int y){
        int sum = arr[x][y];
        Queue<Square> queue = new LinkedList<>();
        list = new ArrayList<>();

        Square firstSquare = new Square(x,y);
        queue.add(firstSquare);
        list.add(firstSquare);

        visit[x][y] = true;

        while (!queue.isEmpty()){
            Square square = queue.poll();

            for (int i = 0; i < 4; i++){
                int nx = dx[i] +  square.x;
                int ny = dy[i] + square.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n){
                    continue;
                }

                if (!visit[nx][ny]){
                    int diff = Math.abs(arr[nx][ny] - arr[square.x][square.y]);

                    if (diff >= l && diff <= r) {

                        Square newSquare = new Square(nx, ny);
                        queue.add(newSquare);
                        list.add(newSquare);
                        visit[nx][ny] = true;
                        sum += arr[nx][ny];
                    }
                }
            }
        }

        return sum;
    }

    public static void changePeopleNum(int sum){
        int len = list.size();
        int balanceNum = sum / len;

        for (int i = 0; i < len; i++){
            int x = list.get(i).x;
            int y = list.get(i).y;
            arr[x][y] = balanceNum;
        }
    }

}

class Square{
    int x;
    int y;

    Square(int x, int y){
        this.x = x;
        this.y = y;
    }

}