import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;

        // 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려준다
        // 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있다.
        // n = 5, lost = [2,4], reserve = [1,3,5] return 5
        // n = 5, lost = [2,4], reserve = [3] return 4
        // n = 3, lost =[3], reserve = [1] return 2

        // 배열을 정렬하기
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> lostList = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toList());

        for(int i =0; i<lost.length; i++){
            if(reserveList.contains(lost[i])){
                System.out.println(lost[i]);
                reserveList.remove(Integer.valueOf(lost[i]));
                lostList.remove(Integer.valueOf(lost[i]));
                answer++;
            }
        }

        for(int i=0; i<lostList.size(); i++){
            System.out.println(lostList.get(i));
            if(reserveList.contains(lostList.get(i)-1)){
                reserveList.remove(Integer.valueOf(lostList.get(i)-1));
                answer++;
            }
            else if(reserveList.contains(lostList.get(i)+1)){
                reserveList.remove(Integer.valueOf(lostList.get(i)+1));
                answer++;
            }
        }

        return answer;
    }
}