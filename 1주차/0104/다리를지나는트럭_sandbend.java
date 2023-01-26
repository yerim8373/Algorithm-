import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭_sendband {

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            int sum = 0;
            int time = 0;

            for (int i=0; i<truck_weights.length; i++) {

                int truck = truck_weights[i];

                while (true) {
                    if (queue.isEmpty()) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    else if (queue.size() == bridge_length) {
                        sum -= queue.poll();
                    }
                    else {
                        if (sum + truck <= weight) {
                            queue.add(truck);
                            sum += truck;
                            time++;
                            break;
                        }
                        else {
                            queue.add(0);
                            time++;
                        }
                    }
                }
            }
            answer = time+bridge_length;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int bridge_lengh = 2;
        int weight = 10;
        int[] truck_weight = {7,4,5,6};
        System.out.println(method.solution(bridge_lengh,weight,truck_weight));
    }
}
