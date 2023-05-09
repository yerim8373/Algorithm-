import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        // 나무들의 초기 높이는 모두 0

        // 사과나무를 무럭무럭 키우기 위해 이하는 물뿌리개 2개를 준비
        // 한 물뿌리개는 나무 하나를 1만큼 성장 ,2만큼 성장,

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int sum = 0;
        int num = 0;

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
            if (arr[i] % 2 == 1){
                num++;
            }
        }

        if(sum%3 == 0 && num <= sum / 3) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}