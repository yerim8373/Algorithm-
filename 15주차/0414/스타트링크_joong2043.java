import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    static boolean[] visit;
    static int f,u,d,g;

    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고
        // 스타트링크가있는 곳의 위치는 G층이다.
        // 강호가 지금 있는 곳은 S층이고 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
        // 보통 엘리베이터는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼 2개밖에 없다.

        // 강호가 G층에 도착하려면 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램

        // 첫째 줄에 강호가 S층에서 G층으로 가기 위해 눌러야 한는 버튼의 수의 최소값을 출력한다.

        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visit = new boolean[f+1];

        // s - > g
        bfs(s);

        if (minNum == Integer.MAX_VALUE){
            bw.write("use the stairs");
        }
        else {
            bw.write(minNum + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int s){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(s,0));

        visit[s] = true;

        while (!queue.isEmpty()){
            Node node  = queue.poll();

            if (node.s == g){
                minNum = Math.min(minNum, node.cnt);
            }

            if (node.s+u <=f && !visit[node.s+u]){
                queue.add(new Node(node.s+u, node.cnt+1));
                visit[node.s+u] = true;
            }

            if (node.s-d > 0 && !visit[node.s - d]) {
                queue.add(new Node(node.s-d, node.cnt+1));
                visit[node.s-d] = true;
            }
        }
    }

}

class Node{
    int s;
    int cnt;

    Node(int s, int cnt){
        this.s = s;
        this.cnt = cnt;
    }
}
