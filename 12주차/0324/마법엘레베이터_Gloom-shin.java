class Solution {
    public int solution(int storey) {
        // 예외케이스
        // 954 => 다 내리면 18,  다 올리면 11, 4내리고 다올리면 10
        // 945 => 다 내리면 19 , 5는 내리고 9는 올리면 12, 다 올리면 10

        // 4이하면 아래로,
        // 6이상이면 위로.
        // 5의 경우는 앞의 수가 5이상이면 크면 위로, 5미만이면 아래로간다.
        int answer = 0;
        int next = storey;
        int num;

        while(next > 0){
            num = next % 10;
            next = next/10;
            if(num <= 4){
                answer+= num;
            }
            else if(num >= 6) {
                answer+= (10-num);
                next++;
            }
            else{ // 5일때
                if(next % 10 >= 5){
                    next++;
                }
                answer+=5;
            }
        }
        return answer;
    }
}