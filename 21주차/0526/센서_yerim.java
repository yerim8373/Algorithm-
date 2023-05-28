import java.io.*;
import java.util.*;

public class gold5_2212_센서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 집중국의 개수가 센서의 개수와 같거나 크면 모든 영역 길이는 0
		if(N <= K) {
			System.out.println(0);
			return;
		}
		
		Arrays.sort(arr);
		
		int[] dist = new int[N-1];
		for (int i = 0; i < arr.length-1; i++) {
			dist[i] = arr[i+1] - arr[i];
		}

		Arrays.sort(dist);
		// 내림차순
//		dist = Arrays.stream(dist)
//				.boxed().sorted(Collections.reverseOrder())
//				.mapToInt(Integer::intValue).toArray();
		
		int result = 0;
		for (int i = 0; i < (N-K); i++) {
			result += dist[i];
		}
		
		System.out.println(result);
		
	}
}