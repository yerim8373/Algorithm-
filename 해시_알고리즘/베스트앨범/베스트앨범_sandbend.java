import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 베스트앨범_sandbend {
    static class Solution {

        static class Music {
            String genere;
            int play;
            int index;

            public Music(String genere, int play, int index) {
                this.genere = genere;
                this.play = play;
                this.index = index;
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            }

            ArrayList<String> geners_ordered = new ArrayList<>();
            while (map.size() != 0) {
                int max = -1;
                String max_key = "";
                for (String key : map.keySet()) {
                    int tmp_cnt = map.get(key);
                    if (tmp_cnt > max) {
                        max = tmp_cnt;
                        max_key = key;
                    }
                }
                geners_ordered.add(max_key);
                map.remove(max_key);
            }

            ArrayList<Music> result = new ArrayList<>();
            for (String gern : geners_ordered) {
                ArrayList<Music> list = new ArrayList<>();
                for (int i = 0; i < genres.length; i++) {
                    if (genres[i].equals(gern)) {
                        list.add(new Music(gern, plays[i], i));
                    }
                }
                Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순
                result.add(list.get(0)); // 1개는 무조건 수록
                if (list.size() != 1) {
                    result.add(list.get(1));
                }
            }

            answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i).index;
            }
            return answer;
        }
    }


    public static void main(String[] args) {
        Solution method = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic","pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(method.solution(genres, plays)));
    }

}
