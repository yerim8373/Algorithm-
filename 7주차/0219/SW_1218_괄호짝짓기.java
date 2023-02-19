package hw.day03;

import java.util.Scanner;
import java.util.Stack;

public class SW_1218_괄호짝짓기 {
    static int T, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = 10;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(sc.nextLine()); //길이
            String str = sc.nextLine(); //괄호

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[' || c == '<' || c == '{') {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '>' && stack.peek() == '<') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            System.out.print("#" + t + " ");
            System.out.println(stack.isEmpty() ? 1 : 0);
        }
    }
}
