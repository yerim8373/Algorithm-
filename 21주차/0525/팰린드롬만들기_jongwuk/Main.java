package 팰린드롬만들기_jongwuk;

import java.util.Scanner;

public class Main {
	static int[] alphabets = new int[26];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		int isOne = 0;
		String answer = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < name.length(); i++) {
			int nameIndex = name.charAt(i) - 'A';
			alphabets[nameIndex]++;
		}

		for (int i = 0; i < alphabets.length; i++) {
			if (alphabets[i] % 2 != 0) {
				isOne++;
			}
		}

		if (isOne > 1) {
			answer += "I'm Sorry Hansoo";
		} else {
			for (int i = 0; i < alphabets.length; i++) {
				for (int j = 0; j < alphabets[i] / 2; j++) {
					sb.append((char)(i + 65));
				}
			}
			answer += sb.toString();
			String last = sb.reverse().toString();

			sb = new StringBuilder();
			for (int i = 0; i < alphabets.length; i++) {
				if (alphabets[i] % 2 == 1) {
					sb.append((char)(i + 65));
				}
			}
			answer += sb.toString() + last;
		}
		System.out.println(answer);

	}
}
