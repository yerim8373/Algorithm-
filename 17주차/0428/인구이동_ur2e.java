import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Location {
    int x;
    int y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static boolean[][] visited;

    // 인접한 땅과 인구수 비교 -> L 과 R 사이이면 참을 리턴
    static boolean checkBoundary(int cx, int cy, int nx, int ny) {
        int sub = Math.abs(map[cx][cy] - map[nx][ny]);
        return (sub >= L && sub <=R);
    }
    // bfs를 통해 연합을 형성
    // 연합이 형성되면 인구를 동일하게 분배한다.
    static int movePeople() {
        int unionCount = 0; // 연합이 형성될 수 있으면 무조건 0 이상의 값을 가진다.

        // (0,0) ~ (N-1, N-1)까지 bfs 수행
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                if(!visited[x][y]) {
                    Queue<Location> queue = new LinkedList<>();
                    Location location = new Location(x,  y);
                    queue.add(location);

                    List<Location> list = new ArrayList<>();
                    list.add(location);

                    visited[location.x][location.y] = true;

                    int unionSum = map[location.x][location.y]; // 인구의 합계

                    while(!queue.isEmpty()) {
                        Location curr = queue.poll();

                        for (int i = 0; i < 4; i++) {
                            int nx = curr.x + dx[i];
                            int ny = curr.y + dy[i];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (!visited[nx][ny] && checkBoundary(curr.x, curr.y, nx, ny)){
                                    queue.add(new Location(nx, ny));
                                    list.add(new Location(nx, ny));
                                    visited[nx][ny] = true;
                                    unionCount++;
                                    unionSum += map[nx][ny];
                                }
                            }
                        }
                    }

                    // 연합 형성 완료 -> unionCount > 0
                    // 연합에 인구를 동등하게 분배한다.
                    if(unionCount > 0) {
                        int avg = unionSum / list.size();

                        for(int i = 0; i <list.size(); i++){
                            Location curr = list.get(i);
                            map[curr.x][curr.y] = avg;
                        }
                    }
                }
            }
        }

        return unionCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0; // 인구 이동 횟수
        boolean flag = true; // 반복문 탈출 flag

        while(flag){
            visited = new boolean[N][N];
            if(movePeople() == 0){
                flag = false;
            } else {
                result++;
            }
        }
        System.out.println(result);
    }
}
