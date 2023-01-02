import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int k, int[] tangerine) {

        List<Integer> list = Arrays.stream(tangerine).boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        //정렬
        Collections.sort(list);
        //숫자당 중복 값을 맵에 저장
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == null) {
                map.put(list.get(i), 1);
            } else {
                map.put(list.get(i), map.get(list.get(i)) + 1);
            }
        }
        //맵에 저장된 중복값
        // System.out.println(map);
        //중복값의 갯수만 다시 list
        List<Integer> list2 = new ArrayList<>(map.values());
        //내림차순 정렬
        Collections.sort(list2, Collections.reverseOrder());
        // System.out.println(list2);
        //result 계산

        int answer = 0;
        for (int i = 0; i < list2.size(); i++) {
            answer++;
            k = k - list2.get(i);
            if (k <= 0) {
                break;
            }

        }
        //정답
        // System.out.println(answer);
        return answer;
    }}
