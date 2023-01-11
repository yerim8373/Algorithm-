import java.util.ArrayList;
import java.util.Arrays;


class Solution {

  public static long factorial(int n) {
    long factorial = 1;
    for(int i = 1; i <= n; i++) {
      factorial *= i;
    }
    return factorial;
  }


  public int[] solution(int n, long k) {
    int[] answer = new int[n];

    // 1. 1 ~ n 만큼 숫자 리스트 생성
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 1; i <= n; i++) {
      list.add(i); // 1 2 3
    }

    // 2. k = k - 1 (실제로는 인덱스가 0부터 시작)
    k = k - 1; // 2

    // 3. n 번만큼 반복
    int index = 0;
    int count = n;
    while(index < count) {
      long split_num = factorial(n) / n;
      int findIndex = (int) (k / split_num);
      answer[index++] = list.get(findIndex);
      list.remove(findIndex);

      k %= split_num;
      n -= 1;
    }


    return answer;
  }
}