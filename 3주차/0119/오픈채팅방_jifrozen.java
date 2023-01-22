import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> arr=new ArrayList<>();
        HashMap<String, String> map=new HashMap<>();
        //1. 문자열 프로세싱
        for(String r:record){
            StringBuilder sb=new StringBuilder();
            String[] strs=r.split(" ");
            String userId=strs[1];
            String nickName="";
            switch(strs[0]){
                case "Enter":
                    nickName=strs[2];
                    sb.append(userId+" "+"들어왔습니다.");
                    map.put(userId,nickName);
                    arr.add(sb.toString());
                    break;
                case "Leave":
                    sb.append(userId+" "+"나갔습니다.");
                    arr.add(sb.toString());
                    break;
                case "Change":
                    nickName=strs[2];
                    map.put(userId,nickName);
                    break;
            }
        }
        //2. 닉네임 변환
        answer=new String[arr.size()];
        for(int i=0;i<arr.size();i++){
            String[] strs=arr.get(i).split(" ");
            answer[i]=map.get(strs[0])+"님이 "+strs[1];
        }

        return answer;
    }
}