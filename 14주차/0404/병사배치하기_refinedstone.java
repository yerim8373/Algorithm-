package 이코테.chapter16;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 병사배치하기_2 {
    public static void main(String[] test) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> li = IntStream.range(0, n).map(i -> sc.nextInt()).boxed().collect(Collectors.toList());
        var dp = new int[n+1];
        /*뒤집어서 최장길이 수열 문제로 변환*/
        Collections.reverse(li);
        Arrays.fill(dp,1);
        /*최소값 로직을 위해 pq*/
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.add(1);
        /*main-logic*/
        for(int i = 1 ; i < n; i++) {
            for (int j = 0; j < i; j++) {
                /*기본 로직*/
                if (li.get(j) < li.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j]+ 1);
                    pq.add(dp[i]);
                }
            }
        }
        // 열외해야 하는 병사의 최소 수를 출력
        System.out.println(n - pq.poll());

    }
}
