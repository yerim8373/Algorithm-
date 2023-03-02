class Solution {
    public int solution(String name) {
        // 대문자로만 이루어 졌다. -> ASCII 코드 대문자 65~ 90
        // 77 -M, 78-N
        int sum = 0;
        
        int Acount = 0; // 연속된 A의 갯수
        int maxA = 0;
        int startIndex = 0;
        int endIndex = 0;
        int command = 0;
        for(int i =0; i< name.length(); i++){
            if(name.charAt(i) == 65){
                command = 0;
                Acount++;
                if(maxA < Acount){
                    maxA = Acount;
                    endIndex = i;
                }
                
            }
            else if(name.charAt(i) <= 77){
                command = name.charAt(i) - 65;
                Acount = 0;
            }
            else{
                command = 91 - name.charAt(i);
                Acount = 0;
            }
            sum += command;
        }
        if(maxA > 0)
            startIndex = endIndex - maxA + 1;
        int startA = 0;
        int endA = name.length()-1;
        for(int i = 0 ; i < name.length(); i++){
            if(name.charAt(startA) != 'A')
                break;
            startA++;
        }
        for (int i = name.length()-1; i >= 0 ; i--) {
            if(name.charAt(endA) != 'A')
                break;
            endA--;
        }

        //greedy A 인곳은 갈 필요가 없다.
        // BABBAAA 와 같은 경우는 가야된다.
        // 즉, 연속된 A가 많은 경우만 빼주면된다.
        //예외 케이스 맨앞이 A인 경우,
        int move = name.length() -1 ;

        if(startA > 0){
            move =  Math.min(move, (name.length() - startA));
        }
        if(endA > 0) {
            move = Math.min(move, endA);
        }
        if(name.length() > 1 && startIndex > 0){
            move = Math.min(move,(startIndex-1)*2 +  (name.length() - endIndex -1));
            move =  Math.min(move ,(name.length() - endIndex -1) *2 + (startIndex-1));
            move =  Math.min(move ,(name.length() - startIndex -1) *2 + (startIndex-1));
        }
        sum+=move;

        return sum;
    }
}