package lv2.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n * m크기의 직사각형에 숫자 1부터 순서대로 증가시키며 달팽이 모양으로 채우는 코드를 작성해보세요.
 * 달팽이 모양이란 왼쪽 위 모서리에서 시작해서, 오른쪽, 아래쪽, 왼쪽, 위쪽 순서로 더 이상 채울 곳이 없을 때까지 회전하는 모양을 의미합니다.
 * n : 행(row), m : 열(column)을 의미합니다.
 */
public class 빙빙돌며숫자적기 {
    static final int[] dx = {0, 1, 0, -1}; // 행
    static final int[] dy = {1, 0, -1, 0}; // 열
    static int dirNum = 0; // 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        fillSnail(arr);
        printArray(arr);
    }

    public static void fillSnail(int[][] arr) {
        int x = 0, y = 0, cnt = 1, dir = 0;
        while (cnt <= N*M) {
            arr[x][y] = cnt++;
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            // 다음 킨이 범위를 벗어나거나 이미 값이 채워져 있으면 방향 전환
            if(!inRange(nextX, nextY) || arr[nextX][nextY] != 0) {
                dir = (dir + 1) % 4;
                nextX = x + dx[dir];
                nextY = y + dy[dir];
            }

            x = nextX;
            y = nextY;
        }

    }

    public static boolean inRange(int x, int y) {
        return (0<= x && x<N && 0<=y && y<M);
    }

    public static void printArray(int[][] arr) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
