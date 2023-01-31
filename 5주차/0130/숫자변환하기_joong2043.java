import java.util.*;
class Solution {
    static int limit;
    static int plusNum;
    static int min=1000000;
    static int[] visited = new int[1000001];
    public int solution(int x, int y, int n) {
        int answer = 0;
        // 자연수 x를 y로 변환한다
        // x에 n을 더한다
        // x에 2를 곱한다
        // x에 3을 곱한다

        // x 10 y 40 n 5


        int num = x;
        int cnt = 0;
        limit = y;
        plusNum = n;

        // dfs 방식은 시간 초과가 남
        // 이러한 최단 거리 문제는 bfs 방식으로 풀자
        answer = bfs(num);

        return answer;
    }

    public static int bfs(int num){
        Queue<Integer> queue = new LinkedList<Integer>();
        int index = num;
        queue.add(num);
        int n = 0;
        visited[num] = 1;

        while(queue.isEmpty() == false){
            n = queue.remove();

            if(n == limit){
                return visited[n] -1;
            }

            if(n*2 <= limit && visited[n*2] == 0){
                visited[n*2] = visited[n]+1;
                queue.add(n*2);
            }
            if(n*3 <= limit && visited[n*3] == 0){
                visited[n*3] = visited[n]+1;
                queue.add(n*3);

            }
            if(n+plusNum <= limit && visited[n+plusNum] == 0){
                visited[n+plusNum] = visited[n]+1;
                queue.add(n+plusNum);
            }

        }
        return -1;
    }
}
