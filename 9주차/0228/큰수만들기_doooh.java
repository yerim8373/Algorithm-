import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;

class Solution {
  public String solution(String number, int k) {

    ArrayList<Integer> stack = new ArrayList<>();

    Integer[] digits = Stream.of(number.split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

    for(Integer digit : digits) {

      while(!stack.isEmpty() && k > 0 && stack.get(stack.size() - 1) < digit) {
        stack.remove(stack.size() - 1);
        k--;
      }
      stack.add(digit);
    }

    List<Integer> bigNumList = stack.subList(0, stack.size() - k);
    StringBuilder answer = new StringBuilder();
    for(Integer val : bigNumList) {
      answer.append(val);
    }

    return answer.toString();
  }
}