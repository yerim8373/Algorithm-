import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        // 튜플
        // n개의 요소를 가진 튜플을 n-튜플
        // 중복된 원소 가능
        // 원소에 정해진 순서가 있음
        // 111 20 -> {111}, {111,20}

        String replacedStr = s.replace("{{","").replace("}}","").replace("},{"," ");

        // System.out.println(replacedStr);

        String[] strArr = replacedStr.split(" ");

        Arrays.sort(strArr,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        // for(String str : strArr){
        //     System.out.println(str);
        // }

        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st;

        for(int i = 0; i<strArr.length; i++){
            st = new StringTokenizer(strArr[i],",");

            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());

                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }

        answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();


        return answer;
    }
}