import java.util.*;
import java.util.HashMap;

// 프로그래머스 위장
public class 위장_sandbend {

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        // 옷 종류 마다 갯수 세기
        for (int i=0; i<clothes.length; i++) {
            String kind  =clothes[i][1];
            // 같은 kind가 있다면 벨류에 +1
            if (map.containsKey(kind)){
                map.put(kind, map.get(kind)+1);
            } else {
                map.put(kind ,1);
            }
        }
        Iterator<Integer> it = map.values().iterator();

        // 다음값이 있을 때까지
        while (it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        return answer-1;
    }


    public static void main(String[ ] args) {
        위장_sandbend method = new 위장_sandbend();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(method.solution(clothes));
    }
}