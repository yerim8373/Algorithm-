import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[N/2];
        int[] up = new int[N/2];

        for (int i = 0; i < N/2 ; i++){
            up[i] = Integer.parseInt(br.readLine());
            down[i] = Integer.parseInt(br.readLine());

        }

        // arr[0] arr[1] arr[2] arr[3] arr[4] arr[5] arr[6] arr[7] arr[8]
        // 1 3 4

        // 최소값
        int min = N;

        int count = 0;

        Arrays.sort(up);
        Arrays.sort(down);

        for (int i = 1; i <= H; i++){
            int countWall = binarySearch(0,N/2,i,down) + binarySearch(0,N/2,H-i+1, up);

            if (min == countWall){
                count++;
                continue;
            }

            if(min>countWall){
                min=countWall;
                count=1;
            }

        }

        bw.write(min +" "+count+"");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int start, int end, int key, int[] arr){

        while(start < end){
            int mid = (start + end) / 2;

            if (arr[mid] <= key){
                end = mid;
            }
            else {
                start = mid;
            }
        }

        return arr.length - end;
    }

}