import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MakeBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 세팅
        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        int M = Integer.parseInt(st.nextToken()); // 숫자가 더해지는 횟수
        int K = Integer.parseInt(st.nextToken()); // K

        st = new StringTokenizer(br.readLine() , " ");


        int max1= 0;
        int max2 =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        // 큰 값 두개
        max1 = pq.poll();
        max2 = pq.poll();
        int sum = 0;

        // 두값이 같을 경우, 다를 경우
        if(max1 == max2){
            sum = max1*M;
        }
        else{ //max1 > max2
            int max2Count = M/(K+1);
            sum += (M-max2Count)*max1;
            sum += max2Count * max2;
        }
        System.out.println("sum = " + sum);

    }
}
