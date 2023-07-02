import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st1.nextToken());
        int C = Integer.parseInt(st1.nextToken());
        String[][] map = new String[R][C]; //입력 넣어줄것

        for (int r = 0 ; r < R ; r++) {
            String row = br.readLine();
            for(int c = 0 ; c < C ; c++) {
                map[r][c] = row.substring(c, c+1);
            }
        }

        //여기까지 오면 map 다 참

        ArrayList<String> words = new ArrayList<>(); //map 의 모든 단어들 넣어줄 ArrayList
        //행렬별로 # 를 기준으로 String 배열을 만든 후, 
        //배열을 순회하며 String 길이가 1보다 길면 words 에 넣어줄것.
        //map 의 단어 전부 words 에 넣은 후, 정렬을 통해 가장 앞의 원소 출력

        for(int r = 0 ; r < R ; r++) {
            String row = "";
            for(int c = 0 ; c < C ; c++) {
                row += map[r][c];
            }

            //여기까지 오면 row = 한 행.
            String[] arr = row.split("#");

            for(int i = 0 ; i < arr.length ; i++) {
                if(arr[i].length() > 1) words.add(arr[i]);
            }
        }

        for(int c = 0 ; c < C ; c++) {
            String column = "";
            for(int r = 0 ; r < R ; r++) {
                column += map[r][c];
            }

            //여기까지 오면 column = 한 열.
            String[] arr = column.split("#");

            for(int i = 0 ; i < arr.length ; i++) {
                if(arr[i].length() > 1) words.add(arr[i]);
            }
        }

        Collections.sort(words);

        bw.write(words.get(0));
        bw.flush();
        bw.close();

    }

}
