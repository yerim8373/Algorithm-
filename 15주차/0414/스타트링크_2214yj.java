import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            F = Integer.parseInt(st.nextToken());   // 총 F층
            S = Integer.parseInt(st.nextToken());   // 강호 위치
            G = Integer.parseInt(st.nextToken());   // 스타 링크 위치
            U = Integer.parseInt(st.nextToken());   // 위로 가는 버튼
            D = Integer.parseInt(st.nextToken());   // 아래로 가는 버튼
            int[] arr = new int[F+1];
            String answer = BFS(arr);
            System.out.println(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String BFS(int[] arr){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(S);
        arr[S] = 1;

        while(!q.isEmpty()){
            int current = q.poll();
            if(current == G) {
                return String.valueOf(arr[current] - 1);
            }
            // 다음 up 이동할 위치가 최대값보다 작고 방문하지 않음 지점이여야 한다.
            if(current + U <= F){
                if(arr[current + U] == 0){
                    arr[current + U] = arr[current] + 1;
                    q.add(current + U);
                }
            }
            // 다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if(current - D > 0){
                if(arr[current - D] == 0) {
                    arr[current - D] = arr[current] + 1;
                    q.add(current - D);
                }
            }
        }
        return "use the stairs";
    }

}
