import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, h;
	static int[] bottom;
	static int[] top;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		bottom = new int[n/2];
		top = new int[n/2];

		int bIdx = 0;
		int tIdx = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (i % 2 == 0) {
				bottom[bIdx ++] = num;
			}else {
				top[tIdx ++] = num;
			}
		}

		Arrays.sort(bottom);
		Arrays.sort(top);

		int minHeight = Integer.MAX_VALUE;
		int count = 0;

		for (int i = 1; i <= h; i++) {
			//높이가 1 ~ h 일 때 부딪히는 개수를 구한다.

			int bottomCount = search(i, bottom);
			int topCount = search(h - i + 1, top);

			if (minHeight > bottomCount + topCount) {
				minHeight = bottomCount + topCount;
				count = 1;
			}else if(minHeight == bottomCount + topCount){
				count ++;
			}
		}

		System.out.println(minHeight + " " + count);
	}

	private static int search(int height, int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= height) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}

		return arr.length - left;

		//1 2 3 4 5
	}

}
