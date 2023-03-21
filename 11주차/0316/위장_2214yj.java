import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap();
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                ArrayList<String> arr = map.get(clothes[i][1]);
                arr.add(clothes[i][0]);
                map.put(clothes[i][1], arr);
            }else{
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(clothes[i][0]);
                map.put(clothes[i][1], arr);
            }
        }
        int cnt = 1;
        for(ArrayList<String> a:map.values()){
            cnt *= (a.size() + 1);
        }
        cnt -= 1;

        return cnt;
    }
}