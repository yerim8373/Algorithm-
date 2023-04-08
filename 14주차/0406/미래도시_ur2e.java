public class Q2_미래도시 {
    public static final int INF = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];

        // 최단 거리 저장할 배열을 무한으로 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        // -> 이거 아래 삼중포문에서 같이 해버리면 안되낭
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) map[i][j] = 0;
            }
        }

        // 각 각선에 대한 정보 입력 받고, 해당 값으로 초기화
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], 1);
            map[end][start] = Math.min(map[end][start], 1);
        }

        st = new StringTokenizer(br.readLine());
        int second = Integer.parseInt(st.nextToken());
        int first = Integer.parseInt(st.nextToken());

        // 기준이 되는 거쳐가는 노드 K
        for(int k = 1; k <= n; k++) {
            // 출발하는 노드 i
            for(int i=1; i <= n; i++) {
                // 도착하는 노드 j
                for(int j=1; j <= n; j++) {
                    //i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }

        int answer = map[1][first] + map[first][second];
        answer = answer > INF ? -1 : answer;
        System.out.println(answer);
    }
}
