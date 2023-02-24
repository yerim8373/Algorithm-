import java.util.*;
class Solution {
    public long solution(int[] weights) {
        Map<Double, Integer> hm = new HashMap<>();
        long answer = 0;
        Arrays.sort(weights);
        for(int weight : weights) {
            answer += helper(weight, hm);
        }
        return answer;
    }

    public long helper(int w, Map<Double, Integer> hm) {
        long cnt = 0;
        double d1 = w*1.0;
        double d2 = (w*2.0)/3.0;
        double d3 = (w*1.0)/2.0;
        double d4 = (w*3.0)/4.0;
        if(hm.containsKey(d1)) cnt += hm.get(d1);
        if(hm.containsKey(d2)) cnt += hm.get(d2);
        if(hm.containsKey(d3)) cnt += hm.get(d3);
        if(hm.containsKey(d4)) cnt += hm.get(d4);
        hm.put(w*1.0, hm.getOrDefault(w*1.0, 0)+1);
        return cnt;
    }
}