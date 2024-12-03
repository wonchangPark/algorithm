package lv2.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N∗N크기의 정사각형 모양의 격자 정보가 주어졌을 때, 가운데 위치에서 북쪽을 향한 상태로 움직이는 것을 시작하려 합니다.
 * T개의 명령에 따라 움직이며, 명령어는 L,R,F로 주어집니다.
 * 명령 L은 왼쪽으로 90도 방향 전환을, 명령 R은 오른쪽으로 90도 방향 전환을, 명령 F가 주어지면 바라보고 있는 방향으로 한칸 이동하게 됩니다.
 * 시작 위치를 포함하여 위치를 이동하게 될 때마다 해당 칸에 적혀있는 수를 계속 더한다고 헀을 때, 이들의 총합을 구하는 프로그램을 구하는 프로그램을 작성해보세요.
 * 단, 격자의 범위를 벗어나게 하는 명령어는 무시해야함에 유의합니다.
 *
 * 입력 형식:
 * 첫 번째 줄에 정수 N과 T가 공백을 사이에 두고 주어집니다.
 * 두 번째 줄에 문자 L, R, 그리고 F로만 이루어진 문자열이 하나 주어집니다.
 * 세 번째 줄부터 N개의 줄에 걸쳐 각 행에 해당하는 n개의 수들이 공백을 사이에 두고 주어집니다.
 *
 * 3 ≤ N ≤ 99 (단, N은 홀수)
 * 1 ≤ T ≤ 100,000
 * 1 ≤ 격자 안의 수 ≤ 9
 */
public class 이동경로상에있는모든숫자더하기 {
    static int[] dx = {0, 1, 0, -1}; // 행 0:오른쪽, 1:아래쪽, 2: 왼쪽, 3:위쪽
    static int[] dy = {1, 0, -1, 0}; // 열
    static int[] L = {3, 0, 1, 2};
    static int[] R = {1, 2, 3, 0};
    static int N,T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        String[] orders = br.readLine().split("");

        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = moveArr(orders, arr);
        System.out.println(cnt);

    }

    private static int moveArr(String[] orders, int[][] arr) {
        int dir = 3; // 북쪽
        int x = N/2;
        int y = N/2;
        int cnt = arr[x][y];

        for(int i=0; i<T; i++) {
            String order = orders[i];

            switch (order) {
                case "L": {
                    dir = L[dir];
                    break;
                }
                case "R": {
                    dir = R[dir];
                    break;
                }
                case "F": {

                    int nx = x + dx[dir];
                    int ny = y + dy[dir] ;

                    if(inRange(nx ,ny)) {
                        x = nx;
                        y = ny;
                        cnt += arr[x][y];
                    }
                }
            }
        }

        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}
