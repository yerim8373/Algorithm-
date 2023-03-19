import java.util.*;

class Solution {

    int answer = 0;
    int N = 0;
    ArrayList<Integer> list;
    public int solution(String[][] clothes) {

        HashMap<String, Integer>  map = new HashMap<>();
        for(String[] cloth : clothes){
            map.put(cloth[1] , map.getOrDefault(cloth[1],0) + 1);
        }
        N = map.keySet().size();



        // hashMap -> List로 변환
        Set<String> keys = map.keySet();
        list = new ArrayList<>();
        for (String key : keys) {
            list.add(map.get(key));
        }


        answer = 1;
        for(int i : list){
            answer *=(i+1);
        }
        // boolean[] visited = new boolean[N];
        // for (int i = 1; i <= N; i++) {
        //     dfs(0,i, 0,1, visited);
        // }

        return answer-1;
    }



    // 테스트 케이스 1번만 시간초과, 30개 모두 다른 종류의 의상인 경우
//     // 조합
//     public void dfs(int count , int n,int nextIndex, int sum, boolean[] visited ){
//         if(count == n){
//             answer += sum;
//             return;
//         }

//         for(int i =nextIndex; i < N; i++){
//             if(visited[i]) continue; // 방문했으면 컨틴뉴
//             visited[i] = true;
//             dfs(count+1, n, i, sum* list.get(i), visited);
//             visited[i] = false;
//         }
//     }
}