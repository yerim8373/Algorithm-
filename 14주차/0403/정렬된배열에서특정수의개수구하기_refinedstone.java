package 이코테.chapter15;

import java.util.Scanner;

/*p367*/
public class 정렬된배열에특정수개수구하기_2 {
    static int answer = 0;
    static int mid = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        /*main-logic*/
        binarySearch(array, m, 0, n-1);
        System.out.println(answer!=0 ? answer : -1);
    }

    static void binarySearch(int[] array, int m, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        /*오른쪽 이동*/
        if (array[mid] < m) {
            binarySearch(array, m, mid + 1, end);
        }
        /*왼쪽 이동*/
        else if (array[mid] > m) {
            binarySearch(array, m, start, mid - 1);
        }
        /*찾았을때*/
        else {
            answer++;
            binarySearch(array, m, start, mid - 1);
            binarySearch(array, m, mid + 1, end);
        }
    }
}
