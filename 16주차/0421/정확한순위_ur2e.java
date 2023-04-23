import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == j) arr[i][j] = 0;
				else arr[i][j] = 10000000;
			}
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
		}
		
        // j와 i, i와 k가 비교 가능하다면 j와 k도 비교가능한 것 -> 플로이드 워셜 알고리즘 사용
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int k = 1; k < n + 1; k++) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}
		
		int total = 0;  
		for (int i = 1; i < n + 1; i++) {
			int count = 0;
			for (int j = 1; j < n + 1; j++) {
				if (arr[i][j] != 10000000 || arr[j][i] != 10000000) 
                	count++;
			}
			
			if (count == n) total++;
		}
		
		System.out.println(total);
	}
}
