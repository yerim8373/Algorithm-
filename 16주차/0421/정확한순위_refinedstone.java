package 이코테.chapter17;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 정확한순위 {
    public static void main(String[] args) {

        var sc = new Scanner(System.in);
        int n = sc.nextInt(); //학생수
        int m = sc.nextInt();//두 학생의 성적을 비교한 횟수
        var arr = new int[n + 1][n + 1];
        IntStream.range(0, n + 1).forEach(i -> Arrays.fill(arr[i], 0));
        // 0 : 비교 데이터 없음
        // 1 : arr[i][j]에서 i의 성적이 더 높음
        // -1: arr[i][j]에서 i의 성적이 더 낮음
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = +1;
            arr[b][a] = -1;
        }
        /*main-logic*/
        //워셜-플로이드
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (arr[i][k] > 0 && arr[k][j] > 0) {
                        arr[i][j] = +1;
                        arr[j][i] = -1;
                    } else if (arr[i][k] < 0 && arr[k][j] < 0) {
                        arr[i][j] = -1;
                        arr[j][i] = +1;
                    }
                }
            }
        }
        int answer = n;

        //순위 검증 로직
        // 하나라도 순위 판별이 안되면 1점씩 깐다.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) continue;
                if (arr[i][j] == 0) {
                    answer = answer - 1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
