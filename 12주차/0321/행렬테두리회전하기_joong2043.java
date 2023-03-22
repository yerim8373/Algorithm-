class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // rows * column 크기인 행렬 있다
        // 행렬에는 1부터 row * column까지의 숫자가 한 줄씩 순서대로 적혀있다.
        // 이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 한다
        // 각 회전은 x1,y1,x2,y2인 정수 4개로 표현, 그 의미는 다음과 같다
        // x1행 y1열부터 x2행 y2열까지의 영역에 해당하는 직사각형에서 테두리에 있는 수자들을 한 칸씩 시계 방향으로 회전

        // 행렬의 세로 길이 rows, 가로 길이 columns 그리고 회전들의 목록 queries가 주어질 때, 각 회전들을 배열에 적용한 뒤,

        // rows, columns
        // 처음에 행렬에는 가로 방향으로 숫자가 1부터 하나씩 증가하면서 적혀있다
        // queries 행의 개수는 1이상 만 이하

        int[][] arr = new int[rows][columns];
        int cnt = 1;

        // 행렬안에 값을 1부터 rows*columns 만큼 순서대로 입력하기
        for(int i = 0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = cnt;
                cnt++;
            }
        }

        // 회전 테두리 좌표 선언
        int startRow, startCol, endRow, endCol, min= 0;

        for(int i = 0; i<queries.length; i++){

            // 회전 테두리 좌표를 위한 x,y값 -1 해주기
            startRow = queries[i][0]-1;
            startCol = queries[i][1]-1;
            endRow = queries[i][2]-1;
            endCol = queries[i][3]-1;

            // arr[startRow][endCol]이 arr[startRow+1][endCol]로 이동할 때 사용할 temp값
            int temp = arr[startRow][endCol];
            // 최소값은 회전 범위 안에 존재하는 temp로 설정하기
            min = temp;

            // 상단 우측으로 이동하는 경우
            for(int j = endCol; j>=startCol+1; j--){
                arr[startRow][j] = arr[startRow][j-1];

                if(min > arr[startRow][j]){
                    min = arr[startRow][j];
                }
            }

            // 좌측 상단으로 이동하는 경우
            for(int j = startRow; j<=endRow-1; j++){

                arr[j][startCol] = arr[j+1][startCol];

                if(min>arr[j][startCol]){
                    min = arr[j][startCol];
                }
            }

            // 하단 좌측으로 이동하는 경우
            for(int j = startCol; j<=endCol-1; j++){

                arr[endRow][j] = arr[endRow][j+1];

                if(min>arr[endRow][j]){
                    min = arr[endRow][j];
                }
            }

            // 우측 하단으로 이동하는 경우
            for(int j = endRow; j>=startRow+1; j--){

                arr[j][endCol] = arr[j-1][endCol];

                if(min > arr[j][endCol]){
                    min = arr[j][endCol];
                }
            }

            arr[startRow+1][endCol] = temp;

            answer[i] = min;

        }

        return answer;
    }
}