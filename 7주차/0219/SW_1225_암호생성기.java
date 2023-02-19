package hw.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225_암호생성기 {
    static int T, tmp, cycle, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<Integer>();

        T = 10;
        for (int t = 1; t <= T; t++) {
            //입력
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            //구현
            cycle = 1;
            tmp = 1;
            while (tmp > 0) {
                if (cycle <= 5) {
                    tmp = q.poll()-cycle;
                    q.offer(tmp);
                    cycle++;
                } else {
                    cycle = 1;
                    tmp = q.poll()-cycle;
                    q.offer(tmp);
                    cycle++;
                }
            }

            //출력
            System.out.print("#" + t + " ");
            for (int i = 0; i < 8; i++) {
                res = q.poll();
                System.out.print(res > 0 ? res : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
