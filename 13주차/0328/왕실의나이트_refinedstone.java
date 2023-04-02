package 이코테.chapter4;

import java.util.Scanner;

public class 왕실의나이트 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int y = s.charAt(0) - 'a';
        int x = s.charAt(1) -  1 ;

        int[][] array = new int[8][8];

        /*수평 두 칸 이동 후 , 수직 한 칸 이동*/
        int[] wayX1 = new int[]{2, -2, 2, -2};
        int[] wayY1 = new int[]{1, -1, -1, 1};

        /*수직 두 칸 이동 후, 수평 한 칸 이동*/
        int[] wayX2 = new int[]{1, -1, -1, 1};
        int[] wayY2 = new int[]{2, -2, 2, -2};

        /*합계*/
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            int newX = x + wayX1[i];
            int newY = y + wayY1[i];
            if(newX>=0 && newY>=0 && newX<8 && newY<8){
                answer++;
            }
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + wayX2[i];
            int newY = y + wayY2[i];
            if(newX>=0 && newY>=0 && newX<8 && newY<8){
                answer++;
            }
        }

        System.out.println(answer);

    }
}
