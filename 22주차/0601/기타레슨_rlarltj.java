import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] lesson;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		lesson = new int[n];

		st = new StringTokenizer(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());

			sum += lesson[i];
			min = Math.min(min, lesson[i]);
		}

		if (m == 1) {
			System.out.println(sum);
			return;
		}


		//lesson을 m개로 동등하게 분할해야 한다.
		System.out.println(search(sum, min));
	}

	private static int search(int sum, int min) {
		int left = min;
		int right = sum;

		while (left <= right) {
			int mid = (left + right) / 2;
			int count = check(mid);

			if (count == -1) {
				left = mid + 1;
			}
			else if (count <= m) {
				right = mid - 1;
			} else if (count > m) {
				left = mid + 1;
				//용량이 초과하거나 남는 경우
			}
		}

		return left;
	}

	private static int check(int mid) {
		//용량이 mid를 넘어가면 새로운 블루레이에 담는다.
		int sum = 0;
		int count = 1;

		for (int i = 0; i < n; i++) {
			if(lesson[i] > mid){
				//아예 담을 수 없는 경우
				return -1;
			}


			if (sum + lesson[i] > mid) {
				//정한 용량을 초과하는 경우
				count ++;
				sum = 0;
			}

			sum += lesson[i];
		}

		return count;
	}
}
