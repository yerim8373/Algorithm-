import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 그리디 문제
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            int count=1;
            int work[]=new int[m+1];
            for(int j=0;j<m;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                work[a]=b;
            }

            int vot= work[1];

            for(int j=2;j<=m;j++){
                if(work[j]<vot){
                    vot=work[j];
                    count++;
                }
            }
            System.out.println(count);

        }
        br.close();
    }
}