import java.util.*;

// 프로그래머스 프린터 스택/큐
public class Main11 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());

        // 큐에다가 큰 숫자 숫서대로 추가
        for (int i=0; i < priorities.length; i++) {
            priorityQueueHighest.add(priorities[i]);
        }

        while (!priorityQueueHighest.isEmpty()) {

            for (int i=0; i<priorities.length; i++) {
                // 인쇄 대기목록과 최상위 큐가 같을 때
                if (priorities[i] == priorityQueueHighest.peek()) {

                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    // 맨앞에 있는 값 반환후 삭제
                    priorityQueueHighest.poll();
                    answer++;
                }
            }
        }
        return -1;
    }
}
