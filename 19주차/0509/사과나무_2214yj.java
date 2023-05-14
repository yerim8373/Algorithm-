import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int odd_cnt = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] % 2 == 1){
                odd_cnt++;
            }
        }
        int sum = Arrays.stream(arr).sum();
        boolean isOk = (sum % 3 == 0) && (odd_cnt <= sum / 3);
        System.out.println(isOk ? "YES" : "NO");
    }

}
