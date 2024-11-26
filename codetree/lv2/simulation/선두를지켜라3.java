package lv2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * A와 B가 동일한 시작점에서 같은 방향으로 출발합니다.
 * 도중에 방향을 바꾸는 경우는 없고, A, B는 각각 N번, M번에 걸쳐 주어지는 특정 속도로 특정 시간만큼 이동한다고 합니다.
 * 이 경기는 특이하게 매 시간마다 현재 선두인 사람들을 모아 명예의 전당에 그 이름을 올려줍니다.
 * A, B의 움직임에 대한 정보가 주어졌을 때 명예의 전당에 올라간 사람의 조합이 총 몇 번 바뀌었는지를 출력하는 프로그램을 작성해보세요.
 *
 * 입력 형식:
 * 첫 번째 줄에 N과 M이 주어집니다.
 * 두 번째 줄부터는 N개의 줄에 걸쳐 각 줄마다 A가 어떤 속도로 몇 시간 동안 이동했는지를 나타내는 (v, t) 값이 공백을 사이에 두고 주어집니다.
 * 그 다음 줄부터는 M개의 줄에 걸쳐 각 줄마다 B가 어떤 속도로 몇 시간 동안 이동했는지를 나타내는 (v, t) 값이 공백을 사이에 두고 주어집니다.
 * A가 총 이동한 시간과 B가 총 이동한 시간은 항상 동일하게 주어짐을 가정해도 좋습니다.
 *
 * 1 ≤ N, M ≤ 1,000
 * 1 ≤ v, t ≤ 1,000
 */
public class 선두를지켜라3 {
    static int N,M;
    static int MAX = 1000 * 1000;
    public static class HallOfFame {
        List<String> list;

        public HallOfFame() {
            this(new ArrayList<>());
        }

        public HallOfFame(List<String> list) {
            this.list = list;
        }

        public void add(String name) {
            list.add(name);
        }

        public boolean isSame(HallOfFame o) {
            if(o == null) {
                return false;
            }
            if(this.list.size() != o.list.size()) {
                return false;
            }
            Collections.sort(this.list);
            Collections.sort(o.list);

            for(int i=0; i<this.list.size(); i++) {
                if(!this.list.get(i).equals(o.list.get(i))){
                    return false;
                }
            }

            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // A
        M = Integer.parseInt(st.nextToken()); // B

        HallOfFame[] hallOfFame = new HallOfFame[MAX]; // 시간 마다의 명예의전당에 기록된 사람
        int[] distA = new int[MAX + 1]; // 시간 마다의 A 가 이동한 총 거리
        int[] distB = new int[MAX + 1]; // 시간 마다의 B 가 이동한 총 거리

        run(br, distA, N);
        run(br, distB, M);

        // 명예의 전당 계산
        for(int i=1; i<MAX; i++) {
            hallOfFame[i] = new HallOfFame();
            if(distA[i] > distB[i]) {
                hallOfFame[i].add("A");
            } else if(distA[i] < distB[i]) {
                hallOfFame[i].add("B");
            } else {
                hallOfFame[i].add("A");
                hallOfFame[i].add("B");
            }
        }

        int cnt = 0;
        for(int i=1; i<MAX; i++) {
            if(!hallOfFame[i].isSame(hallOfFame[i-1])) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void run(BufferedReader br, int[] dist, int moveCnt) throws IOException {
        int now = 0;
        StringTokenizer st;
        for(int i=1; i<=moveCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 속도
            int t = Integer.parseInt(st.nextToken()); // 시간
            for(int j=1; j<=t; j++) {
                dist[now + 1] = dist[now++] + v;
            }
        }

        while (++now < MAX) {
            dist[now] = dist[now-1];
        }
    }
}
