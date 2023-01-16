
//프로그래머스 피로도
public class 피로도_sandbend {

    //DFS를 위한 전역변수 설정
    static boolean[] visit;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {

        //던전 개수만큼 visit 설정
        visit = new boolean[dungeons.length];

        // 최댓값을 위한 cnt
        int cnt = 0;
        DFS(k, dungeons, cnt);

        return answer;
    }

    public static void DFS(int k, int[][] dungeons, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            // visit[i]를 방문하지 않았고 피로도 조건이 맞으면
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                // 소모 피로도를 설정하고 재귀
                DFS(k - dungeons[i][1], dungeons, cnt+1);
                visit[i] = false;
            }
        }
        answer = Math.max(cnt, answer);
    }

    public static void main(String[] args) {
        피로도_sandbend method = new 피로도_sandbend();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(method.solution(k, dungeons));
    }
}