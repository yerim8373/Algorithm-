package algorithm.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기 {
  static int[] Dy;

  static void preprocess() {
    Dy = new int[15];

    Dy[1] = 1;
    Dy[2] = 2;
    Dy[3] = 4;

    for(int i = 4; i <= 10; i++) {
      Dy[i] = Dy[i - 1] + Dy[i - 2] + Dy[i - 3];
    }
  }

  // Dy[i]

  // 1 + 1 + 1 + 1
  // 1 + 1 + 2
  // 1 + 2 + 1
  // 2 + 1 + 1
  // 1 + 3
  // 3 + 1
  // 2 + 2

  static int solution(int N) {
    preprocess();
    return Dy[N];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      System.out.println(solution(N));
    }

  }
}
