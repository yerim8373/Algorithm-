import java.util.Scanner;

public class 크로스워드_geonwoo0215 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		char[][] arr = new char[r][c];

		for (int i = 0; i < r; i++) {
			String s = scanner.next();
			for (int j = 0; j < c; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		String ans = null;

		for (int i = 0; i < c; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j <= r; j++) {
				if (j == r || arr[j][i] == '#') {
					String word = sb.toString();
					if (word.length() > 1) {
						if (ans == null) {
							ans = word;
						} else if (ans.compareTo(word) > 0) {
							ans = word;
						}
					}
					sb = new StringBuilder();
				} else {
					sb.append(arr[j][i]);
				}
			}
		}

		for (int i = 0; i < r; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j <= c; j++) {
				if (j == c || arr[i][j] == '#') {

					String word = sb.toString();
					if (word.length() > 1) {
						if (ans == null) {
							ans = word;
						} else if (ans.compareTo(word) > 0) {
							ans = word;
						}
					}
					sb = new StringBuilder();
				} else {
					sb.append(arr[i][j]);
				}
			}
		}
		System.out.println(ans);

	}

}
