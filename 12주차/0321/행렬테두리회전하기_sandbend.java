import java.util.Arrays;

public class 행렬테두리회전하기_sandbedn {

    static class Solution {
        int[][] matrix;
        public int[] solution(int rows, int colums, int[][] queries) {
            this.matrix = new int[rows][colums]; // 행렬 생성
            int[] answer = new int[queries.length];

            for (int i=0; i<rows; i++) { // 행렬 생성
                for (int j=0; j<colums; j++) {
                    matrix[i][j] = i*colums + j + 1;
                }
            }

            for (int i=0; i< queries.length; i++) {
                answer[i] = rotate(queries[i]); // 회전하고 최소값 저장
            }

            return answer;
        }

        public int rotate(int[] query) {

            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int temp  = this.matrix[x1][y1];
            int min = temp;

            for (int i=x1; i<x2; i++) { // 회전의 1번
                this.matrix[i][y1] = this.matrix[i+1][y1];
                if (min > this.matrix[i][y1]) min = this.matrix[i][y1];
            }
            for (int i=y1; i<y2; i++) { // 회전의 2번
                this.matrix[x2][i] = this.matrix[x2][i+1];
                if (min > this.matrix[x2][i]) min = this.matrix[x2][i];
            }
            for (int i=x2; i>x1; i--) { // 회전의 3번
                this.matrix[i][y2] = this.matrix[i-1][y2];
                if (min > this.matrix[i][y2]) min = this.matrix[i][y2];
            }
            for (int i=y2; i>y1; i--) { // 4번
                this.matrix[x1][i] = this.matrix[x1][i-1];
                if (min > this.matrix[x1][i]) min = this.matrix[x1][i];
            }
            this.matrix[x1][y1+1] = temp; // 빼둔 저장값
            return min;
        }

        public static void main(String[] args) {
            Solution method = new Solution();
            int rows = 6;
            int colums = 6;
            int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
            System.out.println(Arrays.toString(method.solution(rows, colums, queries)));
        }
    }

}
