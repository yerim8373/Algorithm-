import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 데이터의 개수 N, 찾고자 하는 값 x 입력받기
        int n = sc.nextInt();
        int x = sc.nextInt();

        // 전체 데이터 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 값이 [x, x] 범위에 있는 데이터의 개수 계산
        int cnt = count(arr, x);

        // 값이 x인 원소가 존재하지 않는다면
        if (cnt == 0) System.out.println(-1);
            //  값이 x인 원소가 존재한다면
        else System.out.println(cnt);
    }

    public static int count(int[] nums, int target) {
        int first = findFirst(nums, target); // 첫번째 위치 찾기
        if (first == -1) { //배열에 타겟이 없을시
            return -1;
        }
        int last = findLast(nums, target); // 마지막 위치를 찾음
        return last - first + 1;
    }

    private static int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1; // 타겟이 없는경우
    }

    private static int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1; // 타겟이 없는경우
    }
}