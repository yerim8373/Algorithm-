import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] applies = new int[N+1];
            StringTokenizer st;
            for (int i = 1; i < N+1; i++) {
                st = new StringTokenizer(br.readLine());
                applies[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            // 서류 순위가 더 적은 지원자의 경우, 이전 지원자들보다 면접 순위가 높아야 한다.
            int cnt = 1;
            int min = applies[1];
            for (int i = 2; i <= N; i++) {
                if (applies[i] < min) {
                    cnt++;
                    min = applies[i];
                }
            }

            System.out.println(cnt);
        }

    }
}


