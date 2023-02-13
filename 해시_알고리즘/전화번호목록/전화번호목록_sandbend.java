import java.util.HashMap;
import java.util.Map;

public class 전화번호목록_sandbend {
    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Map<String, Integer> map = new HashMap<>();

            // 모든 전화번호를 Hash
            for (int i=0; i<phone_book.length; i++) {
                map.put(phone_book[i], i);
            }

            for (int i=0; i<phone_book.length; i++) {
                for (int j=0; j<phone_book[i].length(); j++) {
                    if (map.containsKey(phone_book[i].substring(0, j))) {
                        answer = false;
                        break;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String[] phone_book = {"123", "456","789"};
        System.out.println(method.solution(phone_book));
    }

}
