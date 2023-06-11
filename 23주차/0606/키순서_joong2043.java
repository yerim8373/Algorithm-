public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 체크 이차원 배열
        boolean[][] check = new boolean[n][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            check[a][b] = true;
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(check[i][k] && check[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }

        int[] cnt = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(check[i][j] || check[j][i]) {
                    cnt[i] ++;
                }
            }
        }

        int res =0;
        for(int num : cnt) {
            if(num == n-1) res++;
        }

        bw.write(res+"");

        bw.flush();
        bw.close();
        br.close();
    }

}