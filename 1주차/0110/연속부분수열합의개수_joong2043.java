import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 배열 2배로 늘리기
        int[] doubleElements = new int[elements.length * 2];

        // 2배로 늘린 배열에 원소값 복사하기
        for(int i = 0; i < elements.length; i++) {
            doubleElements[i] = doubleElements[i + elements.length] = elements[i];
        }

        // 집합 생성하기
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                // 배열 합 구할 때 사용하는 Arrays.stream(배열, start index, end index).sum() 사용
                set.add(Arrays.stream(doubleElements, j, j+i).sum());
            }
        }

        return set.size();
    }
}