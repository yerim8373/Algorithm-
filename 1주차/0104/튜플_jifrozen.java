package 1주차.0104;
import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        //문자열 처리 문제
        //1. 문자 프로세싱 과정
        s=s.replace("{{","").replace("}}","").replace("},{"," ");

        // 결과보기
        // System.out.println("문자 프로세싱 과정\n"+s);
        //배열로 나누기
        String[] strs=s.split(" ");

        //2. 길이순 정렬 -> 튜플이니깐 길이 짧은놈이 앞에 있음
        Arrays.sort(strs,new Comparator<String>() {
            @Override
            public int compare(String o1,String o2){
                return o1.length()-o2.length();
            }
        });

        // System.out.println("길이 순 정렬 완료");
        // for(int i=0;i<strs.length;i++){
        //     System.out.println(strs[i]);
        // }

        // 3. int 배열로 변환
        StringTokenizer st=null;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            st=new StringTokenizer(strs[i],",");
            while(st.hasMoreTokens()){
                int num=Integer.parseInt(st.nextToken());
                if(arr.contains(num)){
                    continue;
                }else{
                    arr.add(num);
                }
            }
        }
        answer=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i]=arr.get(i);
        }


        return answer;
    }
}
