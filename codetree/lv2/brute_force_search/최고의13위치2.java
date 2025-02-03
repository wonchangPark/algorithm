package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최고의13위치2 {

    private static int N;
    private static int sizeY = 3;
    public static void main(String[] args) {
        int[][] board = null;
        try {
            board = readBoard();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        int ans = findBestPlace(board);

        System.out.println(ans);
    }

    /** 세로 1, 가로 3 인 격자이고, 회전이 불가하며 두개가 겹쳐서 올려지면 안된다.
     * 동전의 최대 개수를 구해야함.
     * 두개의 격자 모두 겹치든 말든 모든 부분을 시뮬레이션 하되,
     * 1. 두개의 격자가 겹치거나
     * 2. 두개의 격자중 하나라도 보드의 범위를 넘어가거나
     * 두 개의 조건의 확인해서 아닌 경우 중의 동전의 최대 개수를 구한다.
     */
    private static int findBestPlace(int[][] board) {
        int maxCoin = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) { // 첫번째 격자의 위치를 구한 것.
                if(!inRange(i,j)) {
                    continue;
                }
                for(int k=i; k<N; k++) {
                    for(int l=j; l<N; l++) { // 두번째 격자의 위치
                        if(!inRange(k,l) || isOverlap(i,j,k,l)) {
                            continue;
                        }
                        maxCoin = Math.max(maxCoin, countCoin(board, i, j, k, l));
                    }
                }
            }
        }
        return maxCoin;
    }

    private static int countCoin(int[][] board, int x1, int y1, int x2, int y2) {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(checkPlace(i, j, x1, y1) || checkPlace(i, j, x2, y2)){
                    if(board[i][j] == 1) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static boolean checkPlace(int nowX, int nowY, int x, int y) {
        if(nowX == x) {
            return y <= nowY && nowY < y + sizeY;
        }
        return false;
    }

    private static boolean isOverlap(int x1, int y1, int x2, int y2) {
        if(x1==x2) {
            return y1 + sizeY -1 >= y2;
        }
        return false;
    }

    private static boolean inRange(int x, int y ) {
        return (0<=x && x<N && 0<=y && y+sizeY-1<N);
    }

    private static int[][] readBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return board;
    }
}
