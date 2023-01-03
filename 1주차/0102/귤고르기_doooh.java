import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 귤고르기_doooh {
  public int solution(int k, int[] tangerine) {

    HashMap<Integer, Integer> bucket = new HashMap<Integer, Integer>();
    // 1. 수확한 귤의 크기 : 각 크기의 개수를 HashMap 에 저장
    for(int elem : tangerine) {
      bucket.put(elem, bucket.getOrDefault(elem, 0) + 1);
    }

    // 2. valueList 생성 후, 오름차순 정렬
    List<Integer> valueList = new ArrayList<Integer>(bucket.values());
    Collections.sort(valueList);

    // 3. 서로 다른 종류의 수 최솟값 구하기
    int answer = 0;
    for(int i = valueList.size() - 1; i >= 0; i--) {
      k -= valueList.get(i);
      answer++;

      if(k <= 0)
        break;
    }

    return answer;
  }
}
