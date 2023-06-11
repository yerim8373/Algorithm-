public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] arr =new int[n+2][2];

        //dp 배열 선언
        int[] dp = new int[n+2];

        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            arr[i][0] = time;
            arr[i][1] = price;
        }

        // max값을 -1로 설정
        int max = -1;
        for(int i=1; i<=n+1; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }

            int nxt = i +arr[i][0];
            if(nxt < n+2) {
                dp[nxt] = Math.max(dp[nxt], max+arr[i][1]);
            }
        }

        bw.write(dp[n+1]+"");

        bw.flush();
        bw.close();
        br.close();
    }


}