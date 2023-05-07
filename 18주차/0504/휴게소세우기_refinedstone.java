import java.util.Arrays;
import java.util.Scanner;

public class 휴게소_세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[] restAreas = new int[n];

        for (int i = 0; i < n; i++) {
            restAreas[i] = sc.nextInt();
        }
        Arrays.sort(restAreas);

        int left = 1;
        int right = l - 1;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i < n; i++) {
                int distance = restAreas[i] - restAreas[i - 1];
                count += (distance - 1) / mid;
            }
            count += (restAreas[0] - 0 - 1) / mid;
            count += (l - restAreas[n - 1] - 1) / mid;

            if (count <= m) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
