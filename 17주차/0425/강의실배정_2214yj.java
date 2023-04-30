import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        PriorityQueue<Room> rooms = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            String[] tmp = br.readLine().split(" ");
            rooms.offer(new Room(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        }

        int count = 0;
        PriorityQueue<Integer> startTimes = new PriorityQueue<>(Collections.reverseOrder());
        while(!rooms.isEmpty()){
            Room room = rooms.poll();
            while(!startTimes.isEmpty()){
                int startTime = startTimes.poll();
                if(startTime < room.end){
                    startTimes.offer(startTime);
                    break;
                }
                count -= 1;
            }
            startTimes.offer(room.start);
            count += 1;
            max = Math.max(count, max);
        }
        System.out.println(max);

    }

}

class Room implements Comparable<Room>{
    int start;
    int end;
    Room(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room o) {
        if(this.end == o.end){
            return o.start - this.start;
        }else{
            return o.end - this.end;
        }
    }
}
