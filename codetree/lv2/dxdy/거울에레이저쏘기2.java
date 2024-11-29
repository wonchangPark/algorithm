package lv2.dxdy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * N * N 크기의 격자 안에 각 칸마다 거울이 하나씩 들어 있습니다.
 * 각 거울은 \나 /의 형태를 띄고있고, 격자 밖 4N개의 위치 중 특정 위치에서 레이저를 쏘았을 때, 거울에 튕기는 횟수를 구하는 프로그램을 작성해보세요.
 *
 * 입력 형식:
 * 첫 번째 줄에 N이 주어집니다.
 *
 * 두 번째 줄부터 N개의 줄에 걸쳐 맵의 정보가 주어집니다. 각 줄에는 각 행에 해당하는 정보가 공백없이 주어집니다. 이는 /나 \ 문자로만 이루어져 있습니다.
 * 그 다음 줄에는 레이저를 쏘는 위치 K가 주어집니다.
 * K는 다음과 같이 위에서 아래 방향으로 1행 1열 칸으로 들어오는 곳을 1번으로 하여
 * 시계 방향으로 돌며 가능한 시작 위치에 순서대로 번호를 붙여 4N 번을 마지막으로 했을 때의 번호들 중 하나의 값으로 주어집니다.
 * 1 ≤ N ≤ 1,000
 * 1 ≤ K ≤ 4N
 */
public class 거울에레이저쏘기2 {
    static int[] dx = {0, 1, 0, -1}; // 행: 0:오른쪽, 1:아래, 2:왼쪽, 3:위
    static int[] dy = {1, 0, -1, 0}; // 열
    static int[] mirrorLeftTilted = {1, 0, 3, 2}; // 바뀌는 방향. dir -> dir
    static int[] mirrorRightTilted = {3, 2, 1, 0};
    static int[] directionK = {1, 2, 3, 0};
    static int N,K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        K = Integer.parseInt(br.readLine()); // 레이저를 쏘는 위치
        Position startPosition = getStartPosition(K);
        int reflections = simulateReflections(arr, startPosition.x, startPosition.y, startPosition.dir);

        System.out.println(reflections);
    }


    /**
     * 시뮬레이션(레이저 쏘기): 거울에 팅기는 횟수 구하기
     * 무조건 레이저는 한칸마다 부딪힌다.
     * -> '/' '\' 두개의 벽마다 들어오는 방향에 따른 나가는 방향이 다름
     */
    private static int simulateReflections(String[][] arr, int x, int y, int dir) {
        int reflections = 0;

        while (inRange(x, y)) {
            reflections++;

            // 방향 변경
            if (Objects.equals(arr[x][y], "/")) {
                dir = mirrorRightTilted[dir];
            } else {
                dir = mirrorLeftTilted[dir];
            }

            // 다음 위치로 이동
            x += dx[dir];
            y += dy[dir];
        }

        return reflections;
    }

    private static Position getStartPosition(int k) {
        int dir = directionK[K / N];
        int x, y;

        switch (K / N) {
            case 0: { // 상단
                x = 0;
                y = K % N - 1;
                break;
            }
            case 1:  { // 오른쪽
                x = K % N - 1;
                y = N - 1;
                break;
            }
            case 2:  { // 하단
                x = N - 1;
                y = N - (K % N);
                break;
            }
            case 3:  { // 왼쪽
                x = N - (K % N);
                y = 0;
                break;
            }
            default:  throw new IllegalArgumentException("Invalid direction: " + K / N);
        }
        return new Position(x, y, dir);
    }

    /**
     * 범위 체크
     */
    private static boolean inRange(int x, int y) {
        return (0<=x && x<N && 0<=y && y<N);
    }


    /**
     * 시작 지점과 방향을 담는 클래스
     */
    private static class Position {
        int x, y, dir;

        Position(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
