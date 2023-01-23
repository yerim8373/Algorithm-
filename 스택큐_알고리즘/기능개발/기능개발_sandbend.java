import java.util.*;

public class 기능개발_sandbend {

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            // 1.남은 작업 일 수를 저장할 큐
            Queue<Integer> queue = new LinkedList<>();
            for (int i=0; i<progresses.length; i++) {
                // 남은 작업일을 계산하여 큐에 추가
                queue.add((int)(Math.ceil((100-progresses[i])/speeds[i])));
            }

            // 2. 현재 작업일과 다음 작업일을 비교
            List<Integer> arr = new ArrayList<>();
            while (!queue.isEmpty()) {
                int day = queue.poll();
                int cnt = 1;

                while (!queue.isEmpty() && day >= queue.peek()) {
                    cnt++;
                    queue.poll();
                }
                arr.add(cnt);
            }

            // 3. ArrayList를 배열로 변환
            int[] answer = new int[arr.size()];
            for (int i=0; i<answer.length; i++) {
                answer[i] = arr.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        System.out.println(Arrays.toString(method.solution(progresses, speeds)));
    }
}
