import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] sensor;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		sensor = new int[n];

		for (int i = 0; i < n; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sensor);
		//1 3     6 6 7 9
		// 2    +    3    =  5

		//3    6 7 8    10 12     14 15     18 20
		//0      2        2         1         2  =  7

		Integer[] diff = new Integer[n - 1];

		for (int i = 0; i < n - 1; i++) {
			diff[i] = sensor[i + 1] - sensor[i];
		}

		Arrays.sort(diff, Collections.reverseOrder());
		// diff = 3 2 2 1 0
		// diff = 3 3 2 2 2 2 1 1 1

		long answer = 0;

		// (기지국의 개수 - 1)개의 거리를 제거할 수 있다.
		for (int i = k - 1; i < diff.length; i++) {
			answer += diff[i];
		}

		System.out.println(answer);
	}
}
