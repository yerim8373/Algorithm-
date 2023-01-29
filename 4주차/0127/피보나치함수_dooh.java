package algorithm.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class 부등호 {

  public static ArrayList<String> resultList = new ArrayList<>();

  public static void dfs(char[] expression, int i, int n, String temp) {
    if(n < 0 || i > expression.length + 1) return;
    if(!temp.contains(String.valueOf(n))) {
      temp += n;
    }

    System.out.println(temp);
    if(temp.length() == expression.length + 1) {
      resultList.add( temp );
      return;
    }

    if(expression[i] < '<'){ // < 9
      dfs(expression, i + 1, --n, temp);
    } else { // '>'
      dfs(expression, i + 1, ++n, temp);
    }


  }
  public static String solution(int k, char[] expressions) {
    for(int n = 0; n <= 9; n++) {
      dfs(expressions, 0, n, "");
    }

    return resultList.toString();
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());

    String inequality = br.readLine().trim();
    char[] expressions = inequality.toCharArray();

    System.out.println(solution(k, expressions));
  }
}
