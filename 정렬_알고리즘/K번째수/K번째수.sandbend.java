import java.util.Arrays;

public class K번째수_sandbend {
    // 프로그래머스 k번째 수
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int n = 0;

            for (int i=0; i< commands.length;i++) {
                int k = 0;

                int[] list = new int[commands[i][1] - commands[i][0] +1];

                for (int j=commands[i][0]; j<=commands[i][1]; j++) {
                    list[k++] = array[j-1];
                }
                Arrays.sort(list);
                answer[n++] = list[commands[i][2] - 1];
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] arry = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(method.solution(arry, commands)));
    }
}
