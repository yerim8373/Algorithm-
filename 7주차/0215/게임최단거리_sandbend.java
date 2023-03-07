import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_sandbend {
    static class Solution {
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        public int solution(int[][] maps) {
            int answer = 0;
            int[][] visited = new int[maps.length][maps[0].length];

            visited[0][0] = 1; // 시작 위치 체크

            //bfs 탐색
            bfs(maps,visited);
            //도착지 값
            answer = visited[maps.length-1][maps[0].length-1];

            //갈수 없으면 -1 return
            if (answer==0) answer = -1;

            return answer;
        }

        public void bfs(int[][] maps, int[][] visited) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0,0});

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];

                //4방 탐색
                for (int i=0; i<4; i++) {
                    //이동 했을 때의 위치
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    //범위 벗어나는지 체크
                    //방문했는지 체크
                    //갈 수 있는 지 체크
                    if (nx>=0 && nx< maps.length && ny>=0 && ny<maps[0].length
                            && visited[nx][ny]==0 && maps[nx][ny]==1) {
                        visited[nx][ny] = visited[x][y] + 1;
                        q.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(method.solution(maps));
    }
}
