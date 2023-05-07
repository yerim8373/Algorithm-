import java.util.*;

public class 숨박꼭질_miimmin {
    static int N, K;
    static int[] v = new int[100001];
    static int[] dx = {-1, 1};

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        v[N]=1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i=0;i<3;i++) {
                int nx;
                if(i==2)
                    nx = cur*2;
                else
                    nx = cur + dx[i];

                if(nx==K) {
                    System.out.println(v[cur]);
                    return;
                }

                if(nx>=0 && nx<v.length && v[nx]==0) {
                    queue.add(nx);
                    v[nx] = v[cur]+1;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K =sc.nextInt();
        if(N==K)
            System.out.println(0);
        else {
            bfs();
        }
    }
}