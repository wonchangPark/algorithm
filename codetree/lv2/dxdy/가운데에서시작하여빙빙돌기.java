package lv2.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n * n크기의 정사각형의 가운데에서 시작하여 오른쪽, 위, 왼쪽, 아래 순서로 더 이상 채울 곳이 없을 때까지 회전하며 숫자를 적어나가려고 합니다.
 * 숫자는 1부터 시작한다고 했을 때, 다음과 같은 모양으로 숫자들을 쭉 채우는 코드를 작성해보세요.
 *
 * 입력 형식:
 * 첫 번째 줄에 크기를 나타내는 n이 주어집니다. 주어지는 n은 항상 홀수라고 가정해도 좋습니다.
 * 1 ≤ n ≤ 100
 */
public class 가운데에서시작하여빙빙돌기 {
    static int[] dx = {0, 1, 0, -1}; // 행: 0:오른쪽 1:아래쪽 2:왼쪽 3:위쪽
    static int[] dy = {1, 0, -1, 0}; // 열
    static int[] dirArr = {0, 3, 2, 1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        fillArr(arr);
        printArr(arr);
    }

    private static void printArr(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void fillArr(int[][] arr) {
        int x = n/2;
        int y = n/2;
        int cnt = 1;
        int dir = 0;
        // 규칙이 1,1,2,2,3,3... 순으로 커진다.
        int len = 1;
        int lenCnt = 1;
        int lenFlag = 2;

        while (cnt <= n*n) {
            arr[x][y] = cnt++;

            if(lenCnt == 0) {
                lenFlag--;
                dir = (dir + 1) % 4;
                if(lenFlag == 0) {
                    len++;
                    lenCnt = len;
                    lenFlag = 2;
                } else {
                    lenCnt = len;
                }
            }

            x = x + dx[dirArr[dir]];
            y = y + dy[dirArr[dir]];

            lenCnt--;
        }
    }
}
