import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        // list 생성
        List<Integer> list = new ArrayList<>();

        long factor= factorial(n);
        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        // n = 3
        // k = 5
        k--;
        int idx = 0;
        while(n > 0){
            // factor = 6 / 3 - 0
            factor = factor / n;

            // list.remove() -> 리스트에서 제거하는 값을 반환
            answer[idx++] = list.remove((int) (k / factor));

            k = k % factor;
            n--;
        }

        return answer;
    }

    // factorial 메서드 생성
    public static long factorial(int num){
        if(num == 1){
            return 1;
        }

        return (long) num * factorial(num-1);
    }

}