import java.util.Scanner;
import java.util.stream.IntStream;

public class Test37 {
    static int[][] array;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        array = new int[N][2];

        IntStream.range(0, N).forEach(i -> {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        });

        DFS(0, 1, 0, 0);
        System.out.println(answer);
    }

    static void DFS(int depth, int a, int b, int count) {
        // 범위 조건
        if (depth == array.length) {
            // 1 이상의 재료를 사용했을 경우만 정답으로 간주
            if (count > 0) {
                int diff = Math.abs(a - b);
                if (diff < answer) {
                    answer = diff;
                }
            }
            return;
        }
        // 재료를 선택하는 경우
        DFS(depth + 1, a * array[depth][0], b + array[depth][1], count + 1);
        // 재료를 선택하지 않는 경우
        DFS(depth + 1, a, b, count);

    }
}
