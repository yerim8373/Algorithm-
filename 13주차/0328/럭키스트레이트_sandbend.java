import java.util.Scanner;

public class 럭키스트레이트_sandbend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int sum1 = 0;
        int sum2 = 0;

        for (int i=0; i<str.length()/2; i++) {
            sum1 += str.charAt(i) - '0';
        }

        for (int i=str.length()/2; i<str.length(); i++) {
            sum2 += str.charAt(i) - '0';
        }

        if (sum1 == sum2) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
