import java.awt.print.Pageable;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import java.lang.*;

// baekjoon_10162

public class Main{

    static int num;
    static boolean[] visit = new boolean[10];

    static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] ineqArr = new String[num];

        for(int i = 0 ;i<num; i++){
            ineqArr[i] = st.nextToken();
        }

        int[] numArr = new int[10];

        for(int i =0; i<10; i++){
            numArr[i] = i;
        }

        String str ="";
        // 완전탐색을 위한 dfs 메서드 실행
        dfs(str, ineqArr,0);

        // 생성된 경우들을 쭉 정렬하기
        Collections.sort(arrayList);

        // 가장 큰 수 출력
        System.out.println(arrayList.get(arrayList.size()-1));
        // 가장 작은 수 출력
        System.out.println(arrayList.get(0));

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(String str, String[] ineqArr, int depth){

        if (depth == num+1){
            arrayList.add(str);
            return;
        }

        for (int i = 0; i<10; i++){
            // depth가 0인 경우
            if (depth==0){
                visit[i] = true;
                dfs(str+i, ineqArr, depth+1);
                visit[i] = false;
            }

            // depth가 1이상일 때
            else if(ineqArr[depth-1].equals("<")){
                if (visit[i] == false && (str.charAt(str.length()-1) < (char) (i + '0'))){
                    visit[i] = true;
                    dfs(str+i, ineqArr, depth+1);
                    visit[i] =false;
                }
            }
            else if(ineqArr[depth-1].equals(">")){
                if (visit[i] == false  && (str.charAt(str.length()-1) > (char) (i + '0'))){
                    visit[i] = true;
                    dfs(str+i, ineqArr, depth+1);
                    visit[i] =false;

                }
            }

        }

    }

}