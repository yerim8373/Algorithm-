import java.util.HashMap;
import java.util.Map;

public class Test36 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        // key = 분류, value = 의상갯수
        Map<String, Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < clothes.length ; i++) {
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }

        // 입지않는 경우(+1)의 곱 연산
        // 헐벗엇을때는 빼준다
//        return map.keySet().stream().mapToInt(key -> (map.get(key) + 1)).reduce(1, (a, b) -> a * b)-1;
        System.out.println(map.keySet().stream().mapToInt(key -> (map.get(key) + 1)).reduce(1, (a, b) -> a * b)-1);
    }
}
