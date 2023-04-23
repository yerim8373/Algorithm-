import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열3_sandbend {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int arr[] = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(Integer.MIN_VALUE);

        for (int i=1; i<=n;i++) {
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            // 확인하는 숫자가 증가수열의 마지막 수보다 큰 경우
            // 수열에 추가해줌
            if (num>list.get(list.size()-1)) list.add(num);
            else {
                while (left < right) {
                    int mid = (left+right) >> 1;

                    if (list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
            }
        }
        System.out.println(list.size()-1 + "\n");
    }
}
