import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] elements) {
        //list화
        List<Integer> list = Arrays.stream(elements).boxed().collect(Collectors.toList());
        //return 갯수, sum값 계산
        int answer = 0;
        //set으로 접근
        Set<Integer> hs = new HashSet<>();
        //수열의 최종 길이 = 배열의 길이-1 까지
        // 마지막은 경우의 수가 1개이므로 +1 해주는 식으로 최적화
        //for문 시작
        for (int i = 1; i < elements.length; i++) {
            // i 수열 길이를 set에 저장
            // 인접한 i개의 수열이어야 함.
            // 원형수열이므로 length가 넘어서면 index 0으로 돌려주는 장치가 있어야함
            // 외부에서 가져오자
            for (int j = 0; j < elements.length; j++) {
                //index 값을 원형수열에 맞게 다시 가져옴
                Integer sum = 0;
                for (int k = 0; k <= i - 1; k++) {
                    sum = sum + list.get(roundNumber(j + k, elements.length));
                }
                //연산을 set에 저장
                // System.out.println("index 선택갯수: " + i+",index 시작번호: "+j+",set에 저장될 값은: "+sum);
                hs.add(sum);
            }
        }
        //size = size +1;
        // System.out.println(hs);
        // System.out.println((hs.size() + 1));
        return hs.size()+1;
    }

    //method
    static int roundNumber(int j, int length) {
        // j가 마지막 인덱스보다 같거나 같으면 그대로 반환
        // 아니면 원형 수열로직으로 전환
        if (j <= (length - 1)) {
            return j;
        } else {
            for (int i = 0; ; i++) {
                j = j - (length);
                if (j <= (length - 1)) {
                    // System.out.println("바뀐 인덱스 번호는 : "+j);
                    return j;
                }
            }
        }
    }
}
