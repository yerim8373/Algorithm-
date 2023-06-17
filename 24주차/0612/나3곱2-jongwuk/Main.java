import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[][] arr = new long[N][2];

		for(int i=0; i<N; i++) {
			arr[i][1] = sc.nextLong();
			long n = arr[i][1];
			while(true) {
				if(n % 3 == 0) { // 3으로 나누어 떨어지는 횟수
					arr[i][0] += 1;
					n /= 3;
				}
				else break;
			}
		}

		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return Long.compare(o1[1], o2[1]);
			}
			else {
				return Long.compare(o2[0], o1[0]);
			}
		});

		for(int i=0; i<N; i++) {
			System.out.print(arr[i][1]+" ");
		}

	}
}
