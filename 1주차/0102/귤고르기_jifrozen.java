
import java.util.Arrays;

class 귤고르기_jifrozen {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] tan = new int[10000001];

        for (int i = 0; i < tangerine.length; i++) {
            tan[tangerine[i]]++;
        }

        Arrays.sort(tan);
        int sum = 0;

        for (int i = tan.length - 1; i >= 0; i--) {
            k -= tan[i];
            answer++;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}
