import java.util.*;
class Solution {

    // 공약수 리스트 리턴
    public List<Integer> get_div(int a){
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(a); i++){
            if( a % i == 0){
                arr.add(i);
                arr.add(a / i);
            }
        }
        return arr;
    }

    //
    public int problem(int[] arr1, int[] arr2){

        // div 리스트를 생성하기
        List<Integer> div = get_div(arr1[0]);

        // div 리스트 역순으로 정렬
        Collections.sort(div, Collections.reverseOrder());

        // 전역변수 설정
        int i, j;
        boolean GCD;

        // div 리스트 돌면서 반복문 수행
        for(i = 0; i<div.size() -1; i++){
            // GCD는 false로 설정
            GCD = false;
            // num은 i번째 인덱스에 해당하는 수 가져오기
            int num = div.get(i);

            // arr1 배열 돌면서 반복문
            for(j = 0; j<arr1.length; j++){
                // 만약 div 리스트의 숫자 중 arr1 배열의 공약수가 있다면
                if(arr1[j] % num != 0){
                    break;
                }
            }

            if(j == arr1.length){
                GCD = true;
            }

            if(GCD){
                for(j = 0; j < arr2.length; j++){
                    if(arr2[j] % num == 0){
                        break;
                    }
                }

                if(j == arr2.length){
                    return num;
                }
            }
        }
        return 0;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;


        int num1, num2 = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        num1 = problem(arrayA, arrayB);
        num2 = problem(arrayB, arrayA);

        answer = num1 > num2 ? num1 : num2;

        return answer;
    }


}