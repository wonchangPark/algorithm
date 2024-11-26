package lv2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1차원 직선 위에서 1초에 한 칸씩 좌우로만 왔다 갔다 하는 로봇 A와 B가 있습니다.
 * A가 움직이는 횟수 n와 B가 움직이는 횟수 m이 주어지고 각각 로봇들이 어느 방향으로 얼만큼 움직였는지가 주어졌을 때,
 * 로봇 A와 B가 바로 직전에는 다른 위치에 있다가 그 다음 번에 같은 위치에 오게 되는 경우가 총 몇 번인지를 구하는 프로그램을 작성해봅니다.
 * 단, 로봇 A, B는 처음에 같은 지점에서 움직이며 이는 횟수에 포함시키지 않습니다.
 * 또한, 각 로봇이 움직임을 종료한 이후에는 같은 위치에 계속 머물러 있으며 이때 역시 다른 로봇이 움직임에 따라 두 로봇이 같은 위치에 오게될 수 있습니다.
 * 다만, 모든 로봇이 움직인 이후의 상황은 생각하지 않습니다.
 *
 * 첫 번째 줄에 각 로봇이 움직인 횟수 n과 m이 각각 공백을 사이에 두고 주어집니다.
 * 두 번째 줄부터는 n개의 줄에 걸쳐 로봇 A가 움직인 정보가 (t, d) 형태로 공백을 사이에 두고 주어집니다. t초 만큼 방향 d로 이동함을 의미하며, d는 ‘L', 또는 'R’로만 주어집니다.
 * 그 다음 줄 부터는 m개의 줄에 걸쳐 로봇 B가 움직인 정보가 (t, d) 형태로 공백을 사이에 두고 주어집니다. 로봇 A와 B 모두 움직인 거리의 총 합은 1,000,000을 넘지 않음을 가정해도 좋습니다.
 *
 * 1 ≤ n, m ≤ 50,000
 */
public class 좌우로움직이는로봇 {
    private static final int OFFSET = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // A가 움직인 정보
        int m = Integer.parseInt(st.nextToken()); // B가 움직인 정보

        int[] distA = new int[OFFSET + 1]; // t 초 후의 A 의 위치
        int[] distB = new int[OFFSET + 1]; // t 초 후의 B 의 위치
        distA[0] = OFFSET;
        distB[0] = OFFSET;

        move(br, n, distA);
        move(br, m, distB);

        int cnt = count(distA, distB);
        System.out.println(cnt);
    }

    private static int count(int[] distA, int[] distB) {
        int cnt = 0;
        for(int i=1; i<=OFFSET; i++) {
            if((distA[i-1] != distB[i-1]) && (distA[i] == distB[i])) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void move(BufferedReader br, int moveCnt, int[] dist) throws IOException {
        int now = 0;
        StringTokenizer st;
        for(int i = 0; i<moveCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            now = writeHistory(dist, t, direction, now);
        }
        while(++now <= OFFSET) {
            dist[now] = dist[now-1];
        }
    }

    private static int writeHistory(int[] dist, int t, String direction, int now) {
        for(int i=1; i<=t; i++) {
            dist[now + 1] = dist[now++] + (direction.equals("L") ? -1 : 1);
        }
        return now;
    }
}
