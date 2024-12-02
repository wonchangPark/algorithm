package lv2.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n * m크기의 직사각형에 숫자 1부터 순서대로 증가시키며 달팽이 모양으로 채우는 코드를 작성해보세요.
 * 달팽이 모양이란 왼쪽 위 모서리에서 시작해서, 아래, 오른쪽, 위쪽, 왼쪽 순서로 더 이상 채울 곳이 없을 때까지 회전하는 모양을 의미합니다.
 * n : 행(row), m : 열(column)을 의미합니다.
 *
 * 입력 형식:
 * n과 m이 공백을 사이에 두고 주어집니다.
 * 1 ≤ n, m ≤ 100
 */
public class 빙빙돌며숫자사각형채우기2 {
    static int[] dx = {0, 1, 0, -1}; // 행: 0:오른쪽, 1:아래, 2:왼쪽, 3:위쪽
    static int[] dy = {1, 0, -1, 0}; // 열
    static int[] dir = {1, 0, 3, 2}; // 순서
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        fillArr(arr);

        StringBuilder sb = new StringBuilder();
        printArr(sb, arr);
        System.out.println(sb);
    }

    private static void printArr(StringBuilder sb, int[][] arr) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void fillArr(int[][] arr) {
        int x = 0;
        int y = 0;
        int cnt = 1;
        int nowDir = 0;
        while (cnt <= n*m) {
            arr[x][y] = cnt++;
            int nx = x + dx[dir[nowDir]];
            int ny = y + dy[dir[nowDir]];
            if(!inRange(nx, ny) || arr[nx][ny] != 0) {
                nowDir =  (nowDir + 1) % 4;
                nx = x + dx[dir[nowDir]];
                ny = y + dy[dir[nowDir]];
            }
            x = nx;
            y = ny;
        }
    }

    private static boolean inRange(int x, int y) {
        return (0<=x && x<n && 0<=y && y<m);
    }
}
