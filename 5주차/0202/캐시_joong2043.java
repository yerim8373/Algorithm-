import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 지도 개발팀에서 근무하는 제이지는 지도에서 도시 이름을 검색하면 해당 도시와 관련된 맛집 게시물들을 데이터베이스에서 읽어 보여주는 서비스를 개발하고 있다.
        // 제이지가 작성한 부분 중 데이터베이스에서 게시물을 가져오는 부분의 실행시간이 너무 오래 걸린 다는 것을 알게 되었다.
        // 어피치는 제이지에게 해당 로직을 개선하라고 닦달
        // 제이지는 DB 캐시를 적용하여 성능 개선 시도
        // 캐시 교체 알고리즘은 LRU 사용

        // 캐시 히트 실행시간 1
        // 캐시 미스 실행시간 5

        // 제주, 판교, 서울, 뉴욕, 엘에이, 제주, 판교, 서울,

        ArrayList<String> cityList = new ArrayList<>();
        String[] citiesTemp = new String[cities.length];

        // 캐시 사이즈가 0인 경우
        if(cacheSize<1){
            return 5 * cities.length;
        }

        // 캐시 사이즈가 0보다 큰 경우
        for(int i =0; i< cities.length; i++){
            citiesTemp[i] = cities[i].toUpperCase();
        }

        for(int i = 0; i < citiesTemp.length; i++){
            if(cityList.contains(citiesTemp[i])){
                answer+=1;
                cityList.remove(citiesTemp[i]);
                cityList.add(citiesTemp[i]);
            }
            else{
                answer+=5;
                if(cityList.size() >= cacheSize){
                    cityList.remove(0);
                }
                cityList.add(citiesTemp[i]);
            }
            // System.out.println(citiesTemp[i] + "  " +answer);
        }

        return answer;
    }
}