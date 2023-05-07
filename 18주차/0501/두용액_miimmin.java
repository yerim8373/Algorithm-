import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_miimmin {

    public static Integer[] sol (int[] arr, int N){
        Integer[] ans = new Integer[2];
        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int resL = 0, resR = 0;
        int min = Integer.MAX_VALUE;
        while(true) {
            if(left==right) break;
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) <= min) {
                min = Math.min(min, Math.abs(sum));
                resL = arr[left];
                resR = arr[right];
            }
            if(sum < 0) {
                left++;
            } else {
                right--;
            }

        }

        ans[0] = resL;
        ans[1] = resR;
        return ans;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] ans = new Integer[2];
        ans = sol(arr, N);
        System.out.println(ans[0] + " " + ans[1]);
    }

}