import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int i=0;i<t;i++){
            int n = scanner.nextInt();
            int arr[] = new int[n+1];
            for(int j=0;j<n;j++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                arr[a] = b; // 인덱스 - 서류 성적, 값 - 면접 순위 -> 서류 성적 정렬 필요 없음
            }

            int temp = arr[1];
            int answer = 1;

            for(int j=2;j<=n;j++){
                if(arr[j]<temp){
                    temp = arr[j];
                    answer++;
                }
            }
            System.out.println(answer);

        }


    }

}