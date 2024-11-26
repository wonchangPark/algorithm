package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지뢰찾기 {
    static int N;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Character.isDigit(board[i][j])) {
                    placeMines(i, j, board[i][j] - '0');
                }
            }
        }

        int mineCount = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == '*'){
                    mineCount++;
                }
            }
        }
        if (N >= 5) {
            mineCount += (N - 4) * (N - 4);
        }

        System.out.println(mineCount);
    }

    static void placeMines(int x, int y, int count) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(board[nx][ny] == '#' && count>0) {
                    board[nx][ny] = '*';
                    count--;
                } else if(board[nx][ny] == '#'){
                    board[nx][ny] = 's';
                } else if(board[nx][ny] == '*') {
                    count--;
                }
            }
        }
    }
}
