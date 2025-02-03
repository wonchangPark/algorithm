package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M이 주어지고 또 N * M의 문자열이 주어지면 가로, 세로, 대각선 뱡향으로 도중에 방향을 틀지 않고 인접하여 나오는 ‘LEE’ 의 개수를 구하는 프로그램을 작성해보세요.
 */
public class 숨은단어찾기2 {
    private static final int[][] DIRECTION = {
            {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1, -1}, {-1, 0}, {-1, 1} // 오른쪽 부터
    };

    private static int N, M;

    public static void main(String[] args) {

        // L 이 나오면 이제 8방향으로 가면서 ee 가 나오는 지 확인해봐야 한다.
        char[][] board = null;
        try {
            board = readBoard();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        int count = findL(board);
        System.out.println(count);
    }

    private static int findL(char[][] board) {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 'L') {
                    count += findLEE(board, i, j);
                }
            }
        }
        return count;
    }

    private static int findLEE(char[][] board, int x, int y) {
        int count = 0;
        for(int i=0; i<DIRECTION.length; i++) {
            if(findE(board, x, y, i, 0)) {
                count++;
            }
        }

        return count;
    }

    private static boolean findE(char[][] board, int x, int y, int direction, int now) {
        if(now >= 2) {
            return true;
        }

        int dx = DIRECTION[direction][0];
        int dy = DIRECTION[direction][1];
        int nx = x + dx;
        int ny = y + dy;
        if(inRange(nx, ny) && board[nx][ny]=='E') {
            return findE(board, nx, ny, direction, now+1);
        }
        return false;
    }

    private static boolean inRange(int x, int y) {
        return (0<=x && x<N && 0<=y && y<M);
    }

    private static char[][] readBoard() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        return board;
    }
}
