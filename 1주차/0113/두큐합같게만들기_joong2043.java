import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        // 두 개의 큐가 존재한다
        // 하나의 큐를 골라 원소를 추출하고 추출된 원소를 다른 큐에 집어넣는 작업을 통해 각 큐의 원소 합이 같도록 만들려고 한다
        // 필요한 작업의 최소 횟수는 ?
        // 한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행


        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;
        long count = 0;

        for(int i = 0; i<queue1.length; i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
        }

        long totalSum = sum1+sum2;

        if(totalSum%2==1){
            answer = -1;
            return answer;
        }

        for(int i = 0; i<queue1.length; i++){
            if(queue1[i]>totalSum/2||queue2[i]>totalSum/2){
                answer=-1;
                return answer;
            }
        }


        for(int i = 0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        long limitLen = queue1.length * 3;

        while(sum1!=sum2){
            if(count > limitLen){
                answer = -1;
                break;
            }

            if(sum1>sum2){
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                count++;
                answer++;
            }
            else{
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
                count++;
                answer++;
            }
        }

        // answer = count.intValue();
        return answer;
    }
}