import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right-(int)left+1];
        // n행 n열 크기의 비어있는 2차원 배열
        // i = 1,2,3,...,n에 대해서 다음 과정을 반복
        // 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만든다
        // 새로운 1차원 배열을 arr 이라할때 arr[left]
        // 3 3 3     2 2 3
        // 3 3 3 ->  2 2 3
        // 3 3 3     3 3 3

        // right - left < 10^5

        for(int i = 0; i < answer.length; i++){
            int row = (int)((i + left) / n) + 1; // 행
            int col = (int)((i + left) % n) + 1; // 열
            answer[i] = Math.max(row, col);
        }

        return answer;
    }
}