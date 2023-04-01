public class 카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = IntStream.range(0, n).mapToObj(i -> sc.nextInt()).collect(Collectors.toCollection(PriorityQueue::new));
        int answer = 0;
        /*main-logic*/
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b);
            answer = answer + a + b;
        }
        System.out.println(answer);
    }
}
