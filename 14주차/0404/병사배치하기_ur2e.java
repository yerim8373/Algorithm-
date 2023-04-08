public class Q34_병사배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] power = new int[n];
        int[] d = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(d, 1);
        for(int i = 0; i < n; i++){
            power[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(power[i] < power[j]){
                    d[i] = Math.max(d[j]+1, d[i]);
                }
            }
            max = Math.max(max, d[i]);
        }

        int answer = n - (max);
        System.out.println(answer);
    }
}
