import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> answerList = new ArrayList<>();

        // 본래 닉네임이 아닌 가상의 닉네임을 사용하여 채팅방에 들어갈 수 있다
        // 채팅방에서 닉네임을 변경하는 방법
        // 채팅방 나간 후, 새 닉네임으로 다시 들어간다
        // 채팅방에서 닉네임을 변경한다

        HashMap<String, String> hm = new HashMap<>();

        for(int i = 0; i<record.length; i++){
            String[] strArr = record[i].split(" ");

            if(strArr[0].equals("Enter")){
                hm.put(strArr[1],strArr[2]);
            }
            else if(strArr[0].equals("Change")){
                hm.put(strArr[1],strArr[2]);
            }
        }

        for(int i =0; i<record.length; i++){
            String[] strArr = record[i].split(" ");

            if(strArr[0].equals("Enter")){
                answerList.add(hm.get(strArr[1])+"님이 들어왔습니다.");
            }
            else if(strArr[0].equals("Leave")){
                answerList.add(hm.get(strArr[1])+"님이 나갔습니다.");
            }
        }

        answer = answerList.stream().toArray(String[]::new);
        return answer;
    }
}