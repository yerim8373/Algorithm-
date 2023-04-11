import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int solution(int[] score){
        int answer = 1;
        int interviewRank = score[1];

        for (int i = 2; i < score.length; i++) {
            if(score[i] < interviewRank) {
                interviewRank = Math.min(interviewRank, score[i]);
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        int[] answer = new int[T];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 지원자 수
            int[] score = new int[N+1];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                score[a] = b;
            }
            answer[i] = solution(score);
        }

        for(int x: answer){
            System.out.println(x);
        }
    }
}

