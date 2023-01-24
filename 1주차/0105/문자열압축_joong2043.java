import java.util.*;
class Solution {

    public int solution(String s) {
        if(s.length()==1){
            return 1;
        }

        int answer = s.length();

        // 1개 단위
        // aabbaccc
        // 2개 단위
        // 2a2ba


        // s.length() /2 까지 반복 진행
        // 8개의 문자로 이뤄져 있으면
        // 4까지 진행
        String slicedStr = "";
        String compare = "";
        StringBuilder tempStr = new StringBuilder();
        int j = 0;
        for(int i = 1; i <= s.length() / 2; i++){


            // slicedStr을 미리 만들어두기
            slicedStr = s.substring(0,i);
            // System.out.println("초기 slicedStr "+slicedStr);

            j = i;
            int count = 1;

            while(true){
                if(j+i >= s.length()){
                    compare = s.substring(j, s.length());

                    if(slicedStr.equals(compare)){
                        count++;
                        tempStr.append(count);
                    }
                    else{
                        if(count>=2){
                            tempStr.append(count);
                        }
                        tempStr.append(slicedStr);
                    }

                    // System.out.println("길이보다 큰 경우 " + compare);

                    slicedStr = compare;
                    break;
                }

                compare = s.substring(j,j+i);
                // if(i==3){
                //     System.out.println("slicedStr 값은 "+slicedStr);
                //     System.out.println("compare 값은 "+compare);
                // }

                if(slicedStr.equals(compare)){
                    count++;
                    // if(i==3){
                    //     System.out.println("count 값 "+count);
                    // }
                }
                else{
                    if(count>=2){
                        // count가 2보다 큰 경우 tempStr에 3c 이런식으로 추가하기
                        tempStr.append(count);
                        tempStr.append(slicedStr);
                    }
                    else{
                        tempStr.append(slicedStr);
                    }
                    slicedStr = compare;
                    count = 1;
                }
                j = j+i;
            }

            tempStr.append(slicedStr);
            // System.out.println(tempStr);

//             if(i==2){
//                 System.out.println(tempStr);
//             }

//             if(i==3){
//                 System.out.println(tempStr);
//             }

            answer = Math.min(answer,tempStr.length());
            // System.out.println(i+" 최소값은 "+answer);

            tempStr = new StringBuilder();

        }

        return answer;
    }

}