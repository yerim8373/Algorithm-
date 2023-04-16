class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int n = s.length();
        
        int size = n/2, idx = 0;
        int max = n;
        
        while(size > 0) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, 0+size);
            int cnt = 1;
            int num = 1;
            for(int i = size; cnt <= n/size; i += size, cnt++) {
                String curr = s.substring(i, Math.min(i+size, n));
                if(prev.equals(curr)){
                    num++;
                } else {
                    if(num!=1){
                        sb.append(num);
                    } 
                    sb.append(prev);

                    num = 1;
                    prev = curr;
                }   
            }
            if(num!=1){
                sb.append(num);
            } 
            
            sb.append(prev);
            
            max = Math.min(max, sb.toString().length());
            size--;
        }
        return max;
    }
}
