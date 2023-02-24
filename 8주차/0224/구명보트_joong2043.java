import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {

        // 필요한 최대 구명보트 개수 = 사람 수
        int answer = people.length;

        // 사람들의 몸무게가 70, 50, 80, 50

        // 50 50 70 80
        Arrays.sort(people);

        // 맨 앞에 있는 사람
        int j = 0;

        // 맨 뒤에 있는 사람과 맨 앞에 있는 사람을 계속 매칭하는 방식 사용
        for(int i = people.length -1; i>=0; i--){
            if(j<i && people[i] + people[j] <= limit){
                // System.out.println(j+" "+i);
                answer--;
                j = j + 1;
            }
        }

        return answer;
    }
}