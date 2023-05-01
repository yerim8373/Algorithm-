import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        int start, end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Lecture lecture : lectures) {
            if (!queue.isEmpty() && queue.peek() <= lecture.start) {
                queue.poll();
            }
            queue.offer(lecture.end);
        }

        System.out.println(queue.size());
    }
}
