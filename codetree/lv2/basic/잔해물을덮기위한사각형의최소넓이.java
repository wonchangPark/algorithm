package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잔해물을덮기위한사각형의최소넓이 {
    static class Quadrangle {
        int x1;
        int y1;
        int x2;
        int y2;
        public Quadrangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static final int OFFSET = 1000;
    static final int MAX = OFFSET * 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Quadrangle firstQuad = new Quadrangle(Integer.parseInt(st.nextToken())+OFFSET,
                Integer.parseInt(st.nextToken()) + OFFSET,
                Integer.parseInt(st.nextToken()) + OFFSET,
                Integer.parseInt(st.nextToken()) + OFFSET
                );

        st = new StringTokenizer(br.readLine());
        Quadrangle secondQuad = new Quadrangle(Integer.parseInt(st.nextToken())+OFFSET,
                Integer.parseInt(st.nextToken()) + OFFSET,
                Integer.parseInt(st.nextToken()) + OFFSET,
                Integer.parseInt(st.nextToken()) + OFFSET
        );

        int[][] board = new int[MAX][MAX];

        colorQuad(firstQuad, board, 1);
        colorQuad(secondQuad, board, 2);

        int size = getMinimumSizeOfQuad(board);
        System.out.println(size);
    }

    private static int getMinimumSizeOfQuad(int[][] board) {

        // 숫자 1로 저장된 좌측하단과 우측상단의 좌표를 구한다.
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i<MAX; i++) {
            for(int j=0; j<MAX; j++) {
                if(board[i][j] == 1){
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        if(minX == Integer.MAX_VALUE && minY == Integer.MAX_VALUE) {
            // 1 직사각형이 없는 경우
            return 0;
        } else {
            return (maxX - minX + 1) * (maxY - minY + 1);
        }
    }

    private static void colorQuad(Quadrangle quad, int[][] board, int num) {
        for(int i=quad.x1; i<quad.x2; i++) {
            for(int j=quad.y1; j<quad.y2; j++) {
                board[i][j] = num;
            }
        }
    }
}
