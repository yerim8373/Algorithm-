import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int index = 0;
        char arr[] = name.toCharArray();
        int move = arr.length-1;

        for(int i=0;i<arr.length;i++){
            answer+=Math.min(arr[i]-'A', 'Z'-arr[i]+1); // 상하 조작

            // 다음 알파벳이 A일 때, A가 끝나는 지점 구하기
            index = i+1;
            while(index<arr.length && arr[index]=='A'){
                index++;
            }
            // 좌우 조작 2,3번 경우 최솟값 구하기
            move = Math.min(move, i*2+arr.length-index); // 2번째 경우
            move = Math.min(move, (arr.length-index)*2+i); // 3번째 경우
        }


        return answer+move;
    }
}