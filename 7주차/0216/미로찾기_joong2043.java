import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;

import java.lang.*;

import static java.lang.Integer.parseInt;

public class Main{
    static int num;
    static int length;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point{
        int x;
        int y;
        int count;

        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        arr = new int[num][length];
        visit = new boolean[num][length];

        String str;
        for(int i = 0; i < num; i++){
            str = br.readLine();
            for (int j = 0; j < length; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = bfs();

        bw.write(answer+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int bfs(){
        Queue<Point> queue = new LinkedList<>();

        Point point = new Point(0,0,1);

        queue.add(point);

        while (!queue.isEmpty()){

            Point curPoint = queue.poll();

            if (curPoint.x == num-1 && curPoint.y == length-1){
                return curPoint.count;
            }

            for (int i = 0; i<4; i++){
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];

                if(nx < 0 || ny < 0 || nx >=num || ny >= length){
                    continue;
                }

                if (!visit[nx][ny] && arr[nx][ny] == 1){
                    queue.add(new Point(nx,ny,curPoint.count+1));
                    visit[nx][ny] = true;
                }

            }
        }
        return -1;
    }
}