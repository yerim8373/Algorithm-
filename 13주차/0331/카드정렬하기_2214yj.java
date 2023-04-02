import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p363_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            queue.offer(Integer.parseInt(br.readLine()));
        }
        long sum = 0;
        while(queue.size()>1){
            int tmp = queue.poll() + queue.poll();
            queue.offer(tmp);
            sum += tmp;
        }
        System.out.println(sum);

    }
}
