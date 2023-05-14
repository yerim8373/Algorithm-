import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static HashMap<Integer, Character> info;
    static int time = 0, N;

    static int[] r_row = {0, 1, 0, -1};
    static int[] r_col = {1, 0, -1, 0};

    static int[] l_row = {0, -1, 0, 1};
    static int[] l_col = {-1, 0, 1, 0};
    static Deque<int[]> deque = new LinkedList<>();

    static boolean isRight = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;    // 사과
        }

        int L = Integer.parseInt(br.readLine());
        info = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            info.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));   // 방향 전환
        }

        map[1][1] = 2;
        deque.offerLast(new int[]{1, 1});
        move(0, 1, 1);

        System.out.println(time);

    }

    public static void move(int dir, int r, int c) {
        if (info.containsKey(time)) { // 방향 바꾸기
            if (info.get(time) == 'L') {  // 왼쪽으로 회전하는 경우
                if (isRight) { // 오 -> 왼
                    dir = (dir + 1) % 4;
                    isRight = false;
                } else {  // 왼 -> 왼
                    dir = (dir - 1) % 4;
                    if(dir < 0){
                        dir = 4 + dir;
                    }
                }
            } else {  // 오른쪽으로 회전하는 경우
                if (isRight) { // 오 -> 오
                    dir = (dir + 1) % 4;
                } else {  // 왼 -> 오
                    dir = (dir - 1) % 4;
                    if(dir < 0){
                        dir = 4 + dir;
                    }
                    isRight = true;
                }
            }
        }

        int new_r = isRight ? r + r_row[dir] : r + l_row[dir];
        int new_c = isRight ? c + r_col[dir] : c + l_col[dir];
        time++;
        if (0 < new_r && new_r <= N && 0 < new_c && new_c <= N && map[new_r][new_c] != 2) {
            if (map[new_r][new_c] != 1) {
                int[] tail = deque.pollFirst();
                map[tail[0]][tail[1]] = 0;
            }
            map[new_r][new_c] = 2;
            deque.offerLast(new int[]{new_r, new_c});
            move(dir, new_r, new_c);
        }

    }
}
