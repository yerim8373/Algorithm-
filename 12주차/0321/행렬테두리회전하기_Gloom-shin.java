class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {


        int[][] map = new int[rows][columns];


        // 2차원 배열 생성
        for(int i =0; i<rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j-1] = j + (i*columns); // rows가 아니라 columns임 주의!
            }
        }
        int x1;
        int x2;
        int y1;
        int y2;
        int[] answer = new int[queries.length];
        for(int i = 0; i< queries.length; i++){
            x1 = queries[i][0] -1;
            y1 = queries[i][1] -1;
            x2 = queries[i][2] -1;
            y2 = queries[i][3] -1;
            answer[i] = clockwiseMove(map, x1, y1, x2, y2);
        }



        return answer;
    }

    // 최소 검색 및 시계방향 한칸 돌리기 , 각 x,y -1 주의!
    private int clockwiseMove(int[][] map, int x1, int y1, int x2, int y2){
        int min = Integer.MAX_VALUE;
        int temp = map[x1][y1];
        min = Math.min(min, temp);
        //좌측 아래로 체크
        for(int x = x1; x< x2; x++){
            min = Math.min(min, map[x][y1]);
            map[x][y1] = map[x+1][y1];
        }

        // 하단 오른쪽체크
        for(int y = y1; y< y2; y++){
            min = Math.min(min, map[x2][y]);
            map[x2][y] = map[x2][y+1];
        }

        //우측 위로 체크
        for(int x = x2; x> x1; x--){
            min = Math.min(min, map[x][y2]);
            map[x][y2] = map[x-1][y2];
        }
        //상단 왼쪽 체크
        for(int y = y2; y > y1; y--){
            min = Math.min(min, map[x1][y]);
            map[x1][y] = map[x1][y-1];
        }
        map[x1][y1+1] = temp;

        return min;

    }


}