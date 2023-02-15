import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    static int f,g,u,d;
    static int min = Integer.MAX_VALUE;
    public static class Node{
        int stair, cnt;
        public Node(int stair, int cnt){
            this.stair = stair;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 스타트링크
        // 총 F층으로 이루어진 고층 건물에 사무실이 있고 스타트링크가 있는 곳의 위치는 G층이다. 강호가 있는 곳은 S층이고 이제 엘리베이터를 타고 G층으로 이동하려고 한다
        // 보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있짐만, 강호가탄 엘리베이터는 버튼이 2개밖에 없다. U버튼은 위로 U층을 가는 버튼
        // D버튼은 아래로 D층을 가는 버튼이다.
        // 강호가 G층에 도착하려면 , 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램

        // 10(F) 1(S) 10(G) 2(U) 1(D)
        // 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최소값을 출력
        // 1층에서 10층으로 가기 위해 눌러야 하는 버튼 수 최소 값 = 6
        // 1 -> 3 -> 5 -> 7 -> 9 -> 8 -> 10

        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        bfs(s);

        if (min == Integer.MAX_VALUE){
            bw.write("use the stairs");
        }
        else {
            bw.write(min + "");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int s){

        boolean[] visit = new boolean[f+1];

        visit[s] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s,0));

        while (!queue.isEmpty()){
            Node curNode = queue.poll();
            if (curNode.stair == g){
                if (curNode.cnt < min){
                    min = curNode.cnt;
                }
                return;
            }

            if (curNode.stair + u <= f && visit[curNode.stair+u]==false){
                queue.add(new Node(curNode.stair + u, curNode.cnt + 1));
                visit[curNode.stair + u] = true;
            }
            if (curNode.stair - d > 0 && visit[curNode.stair-d] == false){
                queue.add(new Node(curNode.stair - d, curNode.cnt + 1));
                visit[curNode.stair - d] = true;

            }
        }

    }
}