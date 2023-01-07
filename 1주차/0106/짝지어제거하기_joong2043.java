import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        // S = baabaa -> bbaa -> aa -> 0 1반환
        Stack<Character> stacks = new Stack<>();
        char[] chs = s.toCharArray();

        for(int i = 0; i < chs.length; i++){
            if(!stacks.empty() && stacks.peek() == chs[i]){
                stacks.pop();
                continue;
            }
            stacks.push(chs[i]);

        }

        if(stacks.size()==0){
            answer = 1;
        }

        return answer;
    }
}