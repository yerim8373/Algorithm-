import java.util.*;

public class Solution{
    public static int[][] matrix;

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] result = solution(rows, columns, queries);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        matrix = initMatrix(rows, columns);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotateAndGetMin(queries[i]);
        }

        return answer;
    }

    public static int[][] initMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = value++;
            }
        }

        return matrix;
    }

    public static int rotateAndGetMin(int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int temp = matrix[x1][y1];
        int minValue = temp;

        for (int i = x1; i < x2; i++) {
            matrix[i][y1] = matrix[i + 1][y1];
            minValue = Math.min(minValue, matrix[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            matrix[x2][i] = matrix[x2][i + 1];
            minValue = Math.min(minValue, matrix[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            matrix[i][y2] = matrix[i - 1][y2];
            minValue = Math.min(minValue, matrix[i][y2]);
        }

        for (int i = y2; i > y1; i--) {
            matrix[x1][i] = matrix[x1][i - 1];
            minValue = Math.min(minValue, matrix[x1][i]);
        }

        matrix[x1][y1 + 1] = temp;

        return minValue;
    }
}
