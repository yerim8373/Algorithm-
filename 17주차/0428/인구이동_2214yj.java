
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] A;
    static boolean canMove = true;
    static int answer = 0;
    static int N, L, R;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for(int i = 0; i < N; i++){
            A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int index = 1;
        while(canMove){
            move();
//            System.out.println(index+"번");
//            System.out.println(Arrays.deepToString(A).replace("[","").replace("], ","\n").replace("]]","\n\n"));
        }
        System.out.println(answer);

    }

    static void move(){

        boolean moved = false;
        boolean[][] visited = new boolean[N][N];
        // 국경선이 열리는 곳 체크하기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(0 <= i - 1 ){
                    if(L <= Math.abs(A[i-1][j] - A[i][j]) && Math.abs(A[i-1][j] - A[i][j]) <= R){
                        visited[i-1][j] = true;
                        visited[i][j] = true;
                        moved = true;
                    }
                }
                if(0 <= j - 1){
                    if(L <= Math.abs(A[i][j-1] - A[i][j]) && Math.abs(A[i][j-1] - A[i][j]) <= R){
                        visited[i][j-1] = true;
                        visited[i][j] = true;
                        moved = true;
                    }
                }
            }
        }


        if(moved){
            // 열려 있는 국경대로 인구 이동하기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j])  continue;

                    Queue<int[]> q = new LinkedList<>();    // 연결되어 있는 모든 원소를 구하기
                    HashSet<int[]> count = new HashSet<>();    // q를 통해 구한 모든 원소를 저장
                    
                    q.offer(new int[] {i,j});
                    count.add(new int[] {i, j});
                    visited[i][j] = false;

                    while(!q.isEmpty()){
                        int[] last = q.poll();
                        for(int k = 0; k < dx.length; k++){
                            int new_i = last[0] + dx[k];
                            int new_j = last[1] + dy[k];
                            if(0 <= new_i && new_i < N && 0 <= new_j && new_j < N && visited[new_i][new_j]){
                                if(L <= Math.abs(A[last[0]][last[1]] - A[new_i][new_j]) && Math.abs(A[last[0]][last[1]] - A[new_i][new_j]) <= R) {
                                    q.offer(new int[]{new_i, new_j});
                                    count.add(new int[]{new_i, new_j});
                                    visited[new_i][new_j] = false;
                                }
                            }
                        }
                    }

                    int sum = 0;
                    for(int[] last:count){
                        sum += A[last[0]][last[1]];
                    }
                    int avg = sum / count.size();
                    for(int[] last:count){
                        A[last[0]][last[1]] = avg;
                    }
                }
            }
        }

        if(moved)   answer++;
        else canMove = false;
    }
}
