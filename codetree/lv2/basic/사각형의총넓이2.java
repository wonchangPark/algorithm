package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사각형의총넓이2 {
    private static final int OFFSET = 100;
    private static final int MAX = OFFSET*2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[MAX][MAX];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + OFFSET;
            int y1 = Integer.parseInt(st.nextToken()) + OFFSET;
            int x2 = Integer.parseInt(st.nextToken()) + OFFSET;
            int y2 = Integer.parseInt(st.nextToken()) + OFFSET;

            checkQuadrangle(board, x1, y1, x2, y2);
        }

        int width = 0;
        for(int i=0; i<MAX; i++) {
            for(int j=0; j<MAX; j++) {
                if(board[i][j]) width++;
            }
        }

        System.out.println(width);
    }

    private static void checkQuadrangle(boolean[][] board, int x1, int y1, int x2, int y2) {
        for(int i=x1; i<x2; i++) {
            for(int j=y1; j<y2; j++) {
                board[i][j] = true;
            }
        }
    }
}
