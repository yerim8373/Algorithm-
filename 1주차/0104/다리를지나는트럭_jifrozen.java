
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        // 1. 큐 자체를 다리라고 생각하고 구현
        Queue<Integer> q = new LinkedList<>();
        // 2. 트럭 다리 건너기(2가지 경우)
        for (int i = 0; i < truck_weights.length; i++) {
            int num = truck_weights[i];
            while (true) {
                // 2-1. q 크기가 다리 크기이면 다리 지난 트럭으로 꺼냄
                if (q.size() == bridge_length) {
                    sum -= q.poll();
                }
                // 2-2-1. 다리 위 트럭 무게 총합 + 다음 트럭 무게 <= 견딜 수 있는 무게
                if (sum + num <= weight) {
                    sum = sum + num;
                    q.offer(num);
                    answer++;
                    break;
                } else {// 2-2-2. 견딜 수 없는 무게 -> 다리에 0 집어넣음
                    answer++;
                    q.offer(0);
                }
            }
        }
        // 2. 마지막 트럭 건너는거 생각
        answer += bridge_length;
        return answer;
    }
}