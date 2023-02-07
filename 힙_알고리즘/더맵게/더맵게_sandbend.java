import java.util.PriorityQueue;

public class 더맵게_sandbend {

    static class Solution {
        public int solution(int[] scoville, int k) {
            int answer = 0;
            // 가장 작은 값을 뽑기 위해 우선순위 큐 사용
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int aScovile : scoville) {
                heap.offer(aScovile);
            }

            while (heap.peek() < k) {
                // 스코빌 지수를 k이상으로 만들수 없는 경우 = 원소가 한개
                if (heap.size() == 1) {
                    return -1;
                }
                // 작은 값 두개 조회
                int a = heap.poll(); // 첫번째 작은값
                int b = heap.poll(); // 두번째 작은값

                int result = a + (b*2);

                heap.offer(result); // 다시 heap에 삽입
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;
        System.out.println(method.solution(scoville,k));
    }

}
