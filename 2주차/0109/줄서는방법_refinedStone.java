import java.util.ArrayList;

class Test9 {
    public int[] solution(int n, int k) {
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = i+1;
        }
        ArrayList<Integer> answer = new ArrayList<>();
        permutation(n, k-1, numbers, answer);
        int[] ans = new int[answer.size()];
        for(int i =0; i< answer.size();i++) ans[i] = answer.get(i);
        return ans;
    }

    private void permutation(int n, int k, int[] numbers, ArrayList<Integer> answer) {
        if(n == 1) {
            answer.add(numbers[k]);
            return;
        }
        int fac = factorial(n-1);
        int i = k / fac;
        int j = k % fac;
        int firstNum = numbers[i];
        answer.add(firstNum);
        int[] newNumbers = new int[n-1];
        for(int m = 0, t = 0; m < n; m++) {
            if(m != i) {
                newNumbers[t++] = numbers[m];
            }
        }
        permutation(n-1, j, newNumbers, answer);
    }

    private int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
