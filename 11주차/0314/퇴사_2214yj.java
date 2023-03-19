import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int arr[][];
    public static int sum = 0;
    public static int max = 0;
    public static boolean checked = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        int dp[] = new int[N];  // N일차의 상담을 수락했을 때
        for(int i = 0; i < N; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        max_price(0);
        System.out.println(max);
    }

    public static void max_price(int t){

        if(t > arr.length-1){
            max = Math.max(sum, max);
        }else{
            checked = true;
            if(t+arr[t][0] <= arr.length)
                sum += arr[t][1];

            max_price(t+arr[t][0]);
            checked = false;
            if(t+arr[t][0] <= arr.length)
                sum -= arr[t][1];

            max_price(t+1);
        }
    }


}
