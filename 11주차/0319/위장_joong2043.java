import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        // 스파이는 매일 다른 옷을 조합하여 입어 자신을 위장
        HashMap<String, Integer> maps = new HashMap<>();

        for(int i = 0 ; i < clothes.length ; i++){
            maps.put(clothes[i][1], maps.getOrDefault(clothes[i][1],0)+1);
        }

        for(String clothKind : maps.keySet()){
            answer *= (maps.get(clothKind)+1);
        }

//        System.out.println(maps);


        // yellow_hat headgear
        // blue_sunglasses eyewear
        // green_turban headgear

        // 경우의 수 찾기 -> gear개수 * eyewear 개수

        answer -= 1;


        return answer;
    }
}