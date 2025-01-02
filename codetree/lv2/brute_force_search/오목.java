package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목 {
    static final int SIZE = 19;
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; // 오른쪽, 오른쪽아래, 아래, 왼쪽아래, 왼쪽, 왼쪽위, 위, 오른쪽위
    static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) {

        int[][] board = new int[SIZE][SIZE];

        try {
            board = readBoard();
        } catch (IOException e) {
            System.err.println("입력 오류: " + e.getMessage());
            System.exit(1);
        }

        Stone winningStone = findWinningStone(board);
        if (winningStone != null) {
            System.out.println(winningStone.stoneColor);
            // 중간 돌의 좌표는 1-based index
            System.out.println((winningStone.x + 1) + " " + (winningStone.y + 1));
        } else {
            System.out.println(0);
        }
    }

    private static Stone findWinningStone(int[][] board) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == 0) continue;
                for (int direction = 0; direction < dx.length; direction++) {
                    if (isWinningMove(board, x, y, direction)) {
                        // 중간 돌을 계산
                        Stone middleStone = getMiddleStone(board, x, y, direction);
                        return middleStone;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isWinningMove(int[][] board, int startX, int startY, int direction) {
        int stoneColor = board[startX][startY];
        int count = 1;
        int x = startX;
        int y = startY;

        // 이전 방향에 같은 색의 돌이 있는지 확인하여 중복 오목을 방지
        int prevX = startX - dx[direction];
        int prevY = startY - dy[direction];
        if (isInRange(prevX, prevY) && board[prevX][prevY] == stoneColor) {
            return false; // 이미 이전에 체크된 오목의 일부이므로 무시
        }

        while (true) {
            x += dx[direction];
            y += dy[direction];
            if (!isInRange(x, y) || board[x][y] != stoneColor) {
                break;
            }
            count++;
            if (count == 5) {
                // 다섯 개만 체크하여 여섯 개 이상인 경우는 무효
                int nextX = x + dx[direction];
                int nextY = y + dy[direction];
                if (isInRange(nextX, nextY) && board[nextX][nextY] == stoneColor) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private static Stone getMiddleStone(int[][] board, int startX, int startY, int direction) {
        // 오목이 성립하는 시작점에서 방향을 따라 4번 이동하면 마지막 돌
        // 중간 돌은 시작점 + 2번 이동한 돌
        int middleX = startX + dx[direction] * 2;
        int middleY = startY + dy[direction] * 2;
        return new Stone(middleX, middleY, board[startX][startY]);
    }

    public static int[][] readBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[SIZE][SIZE];
        for(int i=0; i<SIZE; i++) {
            String[] s = br.readLine().split("\\s+");
            for(int j=0; j<s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        return board;
    }

    private static boolean isInRange(int x, int y) {
        return (0<=x && x<SIZE && 0<=y && y<SIZE);
    }

    static class Stone implements Comparable<Stone>{
        int x;
        int y;
        int stoneColor;

        public Stone(int x, int y, int stoneColor) {
            this.x = x;
            this.y = y;
            this.stoneColor = stoneColor;
        }

        @Override
        public int compareTo(Stone o) {
            int cmpX = Integer.compare(this.x, o.x);
            if (cmpX != 0) {
                return cmpX;
            }
            return Integer.compare(this.y, o.y);
        }
    }
}
