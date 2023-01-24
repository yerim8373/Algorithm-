import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        // len = 5
        int len = triangle.length;

        // 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 한다
        // 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로 이동이 가능
        // 예를 들어, 3에서는 그 아래칸의 8 또는 1로만 이동이 가능

        // 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최대값을 return
        //     7         [0,0]
        //    3 8     [1,0] [1,1]
        //   8 1 0 [2,0] [2,1] [2,2]
        //  2 7 4 4
        // 4 5 2 6 5

        // 7 -> 3 -> 8 -> 7 -> 5

        // dp의 원소는 해당 원소까지 가기까지의 최대값
        int[][] dp = new int[len][len];

        dp[0][0] = triangle[0][0];

        for(int i = 1; i < len; i++){
            for(int j = 0 ; j < triangle[i].length; j++){
                // 만약 dp 원소가 제일 왼쪽 원소라면 최대값 바로 위 맨 왼쪽 dp 원소의 값에서 triangle 원소를 더한 것과 동일
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                // 만약 dp 원소가 제일 오른쪽 원소라면 최대값 바로 위 맨 오른쪽 dp 원소의 값에서 triangle 원소를 더한 것과 동일
                else if(j==triangle[i].length-1){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                // 나머지의 경우에는 윗줄의 왼쪽 원소에서 더하는 것과 윗줄의 오른쪽 원소에서 더하는 것을 비교
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j] , dp[i-1][j] + triangle[i][j]);
                }
            }
        }

        answer = Arrays.stream(dp[len-1]).max().getAsInt();

        return answer;
    }
}