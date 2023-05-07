import java.io.*;
import java.util.*;

class 휴게소세우기_miimmin {
    static int n, m, l;
    static List<Integer> list;

    static boolean check(int num) {
        int cnt = 0;
        for (int i = 1; i < list.size(); i++) {
            cnt += (list.get(i) - list.get(i - 1) - 1) / num;
        }
        if (cnt > m) return true;
        return false;
    }

    public static int sol (Integer n, Integer m, Integer l){
        Collections.sort(list);

        /**
         * lo를 0으로 잡아주니 divide by zero 런타임에러가 발생한다
         */
        int lo = 1;
        int hi = l;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        list.add(0);
        list.add(l);
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sol(n,m,l));
    }
}