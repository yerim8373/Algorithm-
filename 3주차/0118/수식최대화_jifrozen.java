package 3주차.0118;

import java.util.*;
class Solution {
    static char[][] op={{'*','-','+'},{'*','+','-'},{'+','*','-'},{'+','-','*'},{'-','+','*'},{'-','*','+'}};
    static long max=0;
    public long solution(String expression) {
        //완탐 6가지 경우
        for(int i=0;i<6;i++){
            calc(i,expression);
        }
        return max;
    }

    public void calc(int calcIndex,String expression){
       ArrayList<Long> numbers=new ArrayList<Long>();
        ArrayList<Character> opArr=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        //1. 표현식 프로세싱
        for(char c:expression.toCharArray()){
            if(c=='*'||c=='+'||c=='-'){
                opArr.add(c);
                numbers.add(Long.parseLong(sb.toString()));
                sb=new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
        //2. 수식 + - * 3개
        for(int i=0;i<3;i++){
            //해당 우선순위 수식 가져오기
            char o=op[calcIndex][i];
            while(!opArr.isEmpty()){
                long sum=0;
                //연산자 index
                int index=opArr.indexOf(o);
                if(index==-1) break;
                //해당 연산에 따라 계산
                switch(o){
                    case '+':
                        sum=numbers.get(index)+numbers.get(index+1);
                        break;
                    case '-':
                        sum=numbers.get(index)-numbers.get(index+1);
                        break;
                    case '*':
                        sum=numbers.get(index)*numbers.get(index+1);
                        break;
                }
                //ArrayList add(int index, Object o) 이용 해당 index에 값 추가
                numbers.add(index,sum);
                //계산한 원소 삭제
                numbers.remove(index+1);
                numbers.remove(index+1);
                //연산자 삭제
                opArr.remove(index);
            }
        }
        max=Math.max(max,Math.abs(numbers.get(0)));
    }
}
