package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계속중첩되는사각형 {
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
    enum Color {
        RED(1), BLUE(2);
        int num;

        Color(int num) {
            this.num = num;
        }

        public Color next() {
            return (this == RED) ? BLUE : RED;
        }
    }

    private static final int OFFSET = 100;
    private static final int MAX = OFFSET * 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Quadrangle[] list = new Quadrangle[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i] = new Quadrangle(
                    Integer.parseInt(st.nextToken()) + OFFSET,
                    Integer.parseInt(st.nextToken()) + OFFSET,
                    Integer.parseInt(st.nextToken()) + OFFSET,
                    Integer.parseInt(st.nextToken()) + OFFSET
            );
        }

        int[][] board = new int[MAX][MAX];
        Color color = Color.RED;
        for(int i=0; i<n; i++) {
            simulation(board, list[i], color);
            color = color.next();
        }

        // 파란색 영역의 넓이를 구하기
        int width = getBlueArea(board);
        System.out.println(width);
    }

    private static int getBlueArea(int[][] board) {
        int cnt = 0;
        for(int i=0; i<MAX; i++) {
            for(int j=0; j<MAX; j++) {
                if(board[i][j] == Color.BLUE.num){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void simulation(int[][] board, Quadrangle quadrangle, Color color) {
        for(int i=quadrangle.x1; i<quadrangle.x2; i++) {
            for(int j=quadrangle.y1; j<quadrangle.y2; j++) {
                board[i][j] = color.num;
            }
        }
    }
}
