import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class p321_럭키스트레이트 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int len = N.length();
        int sum_left = IntStream.range(0,len/2).map(i -> N.charAt(i)).sum();
        int sum_right = IntStream.range(len/2,len).map(i -> N.charAt(i)).sum();
        System.out.println(sum_left == sum_right ? "LUCKY" : "READY");
    }
}
