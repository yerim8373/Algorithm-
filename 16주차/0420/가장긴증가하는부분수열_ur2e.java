import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] d = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(d, 1);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++){
                if(arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
            max = Math.max(max, d[i]);
        }

        System.out.println(max);
    }
}

