import java.io.*;
import java.util.StringTokenizer;

public class 사과나무_sandbend {

    // 백준 그리디
    static int sum = 0;
    static int num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];

            if (arr[i] % 2 == 1) {
                num ++;
            }
        }

        if (sum % 3 == 0) { // 3의 배수
            if (num <= sum / 3) { // 홀수의수가 합계/3 보다 적을 때
//                bw.write("YES");
                System.out.println("YES");
            }
        } else {
            bw.write("NO");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
