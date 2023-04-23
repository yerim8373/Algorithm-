import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] result = new int[N];
		Arrays.fill(result, Integer.MAX_VALUE);
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(Arrays.binarySearch(result,arr[i])>=0)continue; // arr[i]원소가 이미 result에 들어있는 상태
			int idx = Math.abs(Arrays.binarySearch(result,arr[i]))-1;
			result[idx] = arr[i]; // 해당 위치에 이미 원소가 존재한다면 그 원소를 덮어씌움
			answer = Math.max(answer, idx+1); // 그 위치가 새로운 곳이라면 LSI의 길이가 갱신
		}
		System.out.println(answer);
	}
}
