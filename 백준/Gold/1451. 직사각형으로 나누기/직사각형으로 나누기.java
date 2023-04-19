import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N,M;
    static long maxValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]); // 행
        M = Integer.parseInt(temp[1]); // 열

        int[][] board = new int[N][M];
        for(int i=0; i<N; i++){
            char[] temp2 = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                board[i][j] = Character.getNumericValue(temp2[j]);
            }
        } // board 완성

        // 행에서만 2개 고르는 경우
        rowForTwo(board, new boolean[N], 0, 0);

        // 열에서만 2개 고르는 경우
        columnForTwo(board, new boolean[M], 0, 0);

        // 행1, 열1개 고르는 경우
        // 4개의 영역이 나오므로 2곳을 합치고 계산해야한다. 이때, 대각선으로는 합치면 안된다.
        oneOne(board);

        System.out.println(maxValue);
    }

    private static void oneOne(int[][] board) {
        // 행 1개, 열 1개 이기 때문에 그냥 (0,0), (0,1), ... , (N,M) 까지 모든 경우로 해보면 된다.
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M-1; j++){
                int rowBorder = i;
                int columnBorder = j;
                long[][] rectangles = new long[2][2];
                // 0~i && 0~j
                long sum = 0;
                for(int k=0; k<=i; k++){
                    for(int l=0; l<=j; l++){
                        sum += board[k][l];
                    }
                }
                rectangles[0][0] = sum;

                // 0~i && j+1~M
                sum = 0;
                for(int k=0; k<=i; k++){
                    for(int l=j+1; l<M; l++){
                        sum += board[k][l];
                    }
                }
                rectangles[0][1] = sum;

                // i+1~N && 0~j
                sum = 0;
                for(int k=i+1; k<N; k++){
                    for(int l=0; l<=j; l++){
                        sum += board[k][l];
                    }
                }
                rectangles[1][0] = sum;

                // i+1~N && j+1~M
                sum = 0;
                for(int k=i+1; k<N; k++){
                    for(int l=j+1; l<M; l++){
                        sum += board[k][l];
                    }
                }
                rectangles[1][1] = sum;

                // 4개의 사각형 중 2개를 합치고 합의 곱 구하기
                long s1 = rectangles[0][0] + rectangles[0][1];
                long s2 = rectangles[1][0];
                long s3 = rectangles[1][1];
                maxValue = Math.max(maxValue, s1 * s2 * s3);
                s1 = rectangles[0][0] + rectangles[1][0];
                s2 = rectangles[0][1];
                s3 = rectangles[1][1];
                maxValue = Math.max(maxValue, s1 * s2 * s3);
                s1 = rectangles[0][1] + rectangles[1][1];
                s2 = rectangles[1][0];
                s3 = rectangles[0][0];
                maxValue = Math.max(maxValue, s1 * s2 * s3);
                s1 = rectangles[1][0] + rectangles[1][1];
                s2 = rectangles[0][1];
                s3 = rectangles[0][0];
                maxValue = Math.max(maxValue, s1 * s2 * s3);
            }
        }

    }

    private static void rowForTwo(int[][] board, boolean[] check, int cnt, int num) {
        if(cnt == 2){
            // 직사각형 무게 구하기
            List<Integer> rows = new ArrayList<>();
            for(int i=0; i<N; i++){
                if(check[i]){
                    rows.add(i);
                }
            }
            int border = 0;
            long total = 1;
            List<Long> sums = new ArrayList<>();
            for (int i=0; i<rows.size(); i++){
                int tempRow = rows.get(i);
                long sum = 0;
                for(int j=border; j<=tempRow; j++){
                    for(int k=0; k<M; k++){
                        sum += board[j][k];
                    }
                }
                sums.add(sum);
                border = tempRow+1;
            }
            long sum = 0;
            for(int j=border; j<N; j++){
                for(int k=0; k<M; k++){
                    sum += board[j][k];
                }
            }
            sums.add(sum);
            for(int i=0; i<sums.size(); i++){
                total *= sums.get(i);
            }

            if(maxValue < total) maxValue = total;
            return;
        }

        for(int i=num; i<N-1; i++){
            check[i] = true;
            rowForTwo(board, check, cnt+1, i+1);
            check[i] = false;
        }

    }

    private static void columnForTwo(int[][] board, boolean[] check, int cnt, int num) {
        if(cnt == 2){
            // 직사각형 무게 구하기
            List<Integer> columns = new ArrayList<>();
            for(int i=0; i<M; i++){
                if(check[i]){
                    columns.add(i);
                }
            }
            int border = 0;
            long total = 1;
            List<Long> sums = new ArrayList<>();
            for (int i=0; i<columns.size(); i++){
                int tempColumn = columns.get(i);
                long sum = 0;
                for(int j=border; j<=tempColumn; j++){
                    for(int k=0; k<N; k++){
                        sum += board[k][j];
                    }
                }
                sums.add(sum);
                border = tempColumn+1;
            }
            long sum = 0;
            for(int j=border; j<M; j++){
                for(int k=0; k<N; k++){
                    sum += board[k][j];
                }
            }
            sums.add(sum);
            for(int i=0; i<sums.size(); i++){
                total *= sums.get(i);
            }

            if(maxValue < total) maxValue = total;
            return;
        }

        for(int i=num; i<M-1; i++){
            check[i] = true;
            columnForTwo(board, check, cnt+1, i+1);
            check[i] = false;
        }
    }


}
