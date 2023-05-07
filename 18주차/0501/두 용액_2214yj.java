import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        int[] result = {0, N - 1};

        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < Math.abs(arr[result[0]] + arr[result[1]])){
                result[0] = left;
                result[1] = right;
            }
            if(sum > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(arr[result[0]] + " " + arr[result[1]]);
    }
}
