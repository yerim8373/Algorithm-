import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  // 최소 공배수 구하기
  private static int gcd(Integer a, Integer b) {
    if(b == 0) return a;
    return gcd(b, a % b);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Integer> list = new ArrayList();
    ArrayList<Integer> gap = new ArrayList<>();

    for(int i = 0; i < N; i++) {
      list.add(Integer.parseInt(br.readLine()));
      if(i > 0) {
        gap.add(list.get(i) - list.get(i - 1));
      }
    }

    // 2. diff 구하기
    for(int i = 0; i <= gap.size() - 2; i++) {
      gap.add(i + 1, gcd(gap.get(i), gap.remove(i + 1)));
    }

    int diff = gap.get(gap.size() - 1);

    // 3. 최소 개수 카운트
    int n = list.get(list.size() - 1) - list.get(0);
    System.out.println(n / diff - gap.size());
  }
}
