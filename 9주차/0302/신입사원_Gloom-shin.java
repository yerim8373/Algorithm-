import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N ;

        StringTokenizer st;
        int documentMax;
        int interviewMax;
        int[][] grade ;
        for (int i = 0; i <T ; i++) {
            N = Integer.parseInt(br.readLine());

            documentMax = N+1;
            interviewMax = N+1;
            grade = new int[N][2];
            int recruit = 0;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                grade[j][0] = Integer.parseInt(st.nextToken());
                grade[j][1] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(grade, (s1, s2) -> s1[0] - s2[0]);
            for (int j = 0; j < N; j++) {
                if(interviewMax > grade[j][1]){
                    recruit++;
                    interviewMax = grade[j][1];
                }
            }
            System.out.println( recruit);
        }

    }
}
