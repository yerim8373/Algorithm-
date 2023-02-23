
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 세준이는 양수와 + - 그리고 괄호
        // 괄호를 다 지웠다
        // 괄호를 적절히 쳐서 이 식의 값을 최소로 만드려고 한다.

        // 문자열 입력
        String equation = br.readLine();

        // 연산자 캐릭터 리스트 선언
        List<Character> operatorList = new ArrayList<>();

        // 문자열에 +나 - 있으면 연산자 리스트에 ADD
        for (int i = 0; i<equation.length(); i++){
            if (equation.charAt(i) == '+' || equation.charAt(i) == '-'){
                operatorList.add(equation.charAt(i));
            }
        }

        // 수학식에서 연산자를 분리한 피연산자 String 배열 생성
        String[] equations = equation.split("\\+|-");
        // 55 50 40

        // 피연산자 String 배열을 int 배열로 변환
        int[] equationsInt = Arrays.stream(equations).mapToInt(Integer::parseInt).toArray();

        // 합계 선언
        int sum =equationsInt[0];

        // -가 시작되는 인덱스
        int minusStartIndex = equationsInt.length;

        // -가 시작되는 인덱스가 있으면 minusStartIndex에 대입, +만 있으면 합계에 계속 값 더해주기
        for (int i = 0; i < operatorList.size(); i++){
            if (operatorList.get(i) == '-'){
                minusStartIndex = i;
                break;
            }
            sum += equationsInt[i+1];
        }

        // -가 시작되는 인덱스에 해당하는 피연산자들을 뺄셈한 합계에 쭉 넣어주기
        for (int i = minusStartIndex+1; i < equationsInt.length; i++){
            sum -= equationsInt[i];
        }

        bw.write(sum+"");

        bw.flush();
        br.close();
        bw.close();
    }

}