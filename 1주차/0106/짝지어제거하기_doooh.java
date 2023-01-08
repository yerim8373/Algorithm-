import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
    int answer = 0;

    // 1. 문자열을 char 배열로 변환 & 스택 마련
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    // 2. 문자열 제거 로직
    for(char ch : chars){
      // i. stack 에 값이 있는 경우
      if(stack.size() > 0) {
        if(stack.peek() == ch) {
          stack.pop();
        } else {
          stack.push(ch);
        }

        // j. stack 이 비어 있는 경우
      } else {
        stack.push(ch);
      }
    }

    // 3. 짝지어모두제거(1), 아니면(0) 결과 반환
    if(stack.size() == 0) answer = 1;

    return answer;

    }
}