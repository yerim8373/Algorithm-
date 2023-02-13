import java.util.HashMap;

public class 완주하지못한선수_sandbend {

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map = new HashMap<>();

            for (String p : participant) {
                map.put(p,map.getOrDefault(p,0) + 1);
            }
            for (String c : completion) {
                map.put(c, map.get(c) - 1);
            }
            for (String key : map.keySet()) {
                if (map.get(key) != 0) {
                    answer = key;
                    break;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(method.solution(participant,completion));
    }

}
