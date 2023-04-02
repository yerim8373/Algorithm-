import java.util.Scanner;

public class p115_왕실의나이트 {
    public static void main(String[] args) {
        int[] x = {1, -1, 1, -1, -2, 2, -2, 2};
        int[] y = {2, 2, -2, -2, -1, -1, 1, 1};
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int col = input.charAt(0) - 'a';
        int row = input.charAt(1) - '1';
        int cnt = 0;
        for (int i = 0; i < x.length; i++) {
            int new_x = col + x[i];
            int new_y = row + y[i];
            if (0 <= new_x && new_x < 8 && 0 <= new_y && new_y < 8) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
