import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 위에서아래로_sandbend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i=0; i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        // 출력
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
