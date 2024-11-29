package lv2.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N * N 크기의 격자 위에 총 M번에 걸쳐 색칠을 진행합니다.
 * 한 번에 한 칸만 색칠하며, 색칠을 한 직후 해당 칸이 '편안한 상태'에 놓여 있는지를 확인하려 합니다.
 * ‘편안한 상태’란 방금 막 칠해진 칸을 기점으로 위 아래 양옆으로 인접한 4개의 칸 중 격자를 벗어나지 않는 칸에 색칠되어 있는 칸이 정확히 3개인 경우를 뜻합니다.
 * 색칠할 칸이 주어질 때마다 해당 칸을 칠한 직후 막 칠한 칸이 편안한 상태에 있는지를 계속 알아내는 프로그램을 작성해보세요.
 *
 * 입력 형식:
 * 첫 번째 줄에는 정수 N과 M이 주어집니다.
 * 두 번째 줄부터는 M개의 줄에 걸쳐 각 줄마다 색칠할 칸의 위치 (r, c) 가 공백을 사이에 두고 주어집니다.
 * 이는 r행 c열에 색칠해야 함을 의미하며, 색칠을 동일한 칸에 2번 이상 하게되는 경우는 없다고 가정해도 좋습니다.
 *
 * 1 ≤ N ≤ 100
 * 1 ≤ M ≤ N * N
 * 1 ≤ r, c ≤ N
 */
public class 격자위의편안한상태 {
    static int[] dr = {0, 1, 0, -1}; // 행: 오른쪽, 아래, 왼쪽, 위 방향
    static int[] dc = {1, 0, -1, 0}; // 열
    static int N,M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[N][N];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = true;

            if(isComfortable(board, r, c)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isComfortable(boolean[][] board, int r, int c) {
        int cnt = 0;
        for(int i=0; i<dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!isRange(nr, nc)) {
                continue;
            }
            if(board[nr][nc]) {
                cnt++;
            }
        }

        return cnt == 3;
    }

    private static boolean isRange(int nr, int nc) {
        return (0 <= nr && nr < N && 0 <= nc && nc < N);
    }
}
