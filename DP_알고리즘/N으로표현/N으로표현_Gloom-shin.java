class Solution {
    static int min = 9;
    public int solution(int N, int number) {
        dfs(0, 0, number, N);
        int answer = -1;
        if(min < 9){
            answer = min;
        }
        return answer;
    }

    private void dfs(int number, int count, int target, int N){
        // N을 사용한 횟수가 8을 넘겼는지 체크
        if(count > 8) return;
        //해당 숫자인지 체크
        if(number == target){
            min = Math.min(count, min);
        }
        int makeNum = N;
        int useN = 1;
        // 그다음 연산할 숫자만들기,N갯수를 넘기지 않을 때 까지
        // 4칙연산 수행
        for(int i= count; i < 9; i++){
            dfs(number + makeNum, count + useN, target, N);
            dfs(number - makeNum, count + useN, target, N);
            dfs(number * makeNum, count + useN, target, N);
            dfs(number / makeNum, count + useN, target, N);
            useN++;
            makeNum = (makeNum *10) + N;
        }
    }
}