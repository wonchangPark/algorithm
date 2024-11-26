package lv2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N명의 개발자들이 있으며, T번에 걸쳐 t초에 x개발자가 y개발자와 악수를 나눈 정황이 주어집니다.
 * 1명의 개발자가 처음에 이 전염병을 옮기기 시작한 것이 확실해 졌고, 개발자가 이 병에 감염된 후에는 정확히 K번의 악수 동안만 전염병을 옮기게 되고,
 * 그 이후부터는 전염병에 걸려있지만 새로 옮기지는 않게 됩니다. 개발자들의 악수에 대한 정보와 처음 전염병에 걸려 있는 개발자의 번호 P가 주어졌을 때,
 * 모든 악수를 진행한 이후에 최종적으로 누가 전염병에 걸리게 되었는지를 알아내는 프로그램을 작성해보세요.
 *
 * 단, 전염된 사람끼리 만나도 전염시킨 것으로 간주해야 합니다.
 * 예를 들어 전염된 x 개발자와 전염된 y 개발자끼리 악수를 해도 전염병을 옮기게 되는 횟수에 포함시켜야 합니다.
 * 이때, 감염 횟수에 포함될 뿐, 이미 전염되었던 사람이 재감염이 되는 것은 아님에 유의합니다.
 *
 * 입력 형식:
 * 첫 번째 줄에 정수 N, K, P, T가 각각 공백을 사이에 두고 주어집니다.
 * 두 번째 줄부터는 T개의 줄에 걸쳐 각 줄마다 t, x, y에 대한 정보가 공백을 사이에 두고 주어집니다.
 * 이는 t초에 x 개발자와 y 개발자가 악수를 나눴음을 의미하고, x, y 값은 항상 다르게 주어짐을 가정해도 좋습니다.
 * 또한, 입력으로 주어지는 t값은 모두 다름을 가정해도 좋습니다.
 *
 * 2 ≤ N ≤ 100
 * 1 ≤ K ≤ 250
 * 1 ≤ P ≤ N
 * 1 ≤ T ≤ 250
 * 1 ≤ t ≤ 250
 */
public class 악수와전염병의상관관계2 {
    static int N,K,P,T;

    private static class HandShake implements Comparable<HandShake> {
        int time;
        int x;
        int y;

        public HandShake(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(HandShake other) {
            return Integer.compare(this.time, other.time);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        K = Integer.parseInt(st.nextToken()); // 전염 시킬 수 있는 횟수
        P = Integer.parseInt(st.nextToken()); // 최초 감염자
        T = Integer.parseInt(st.nextToken()); // T 번의 악수

        // 초기화
        boolean[] isInfected = new boolean[N+1];
        int[] infectionCountLeft = new int[N+1];
        Arrays.fill(infectionCountLeft, K);
        isInfected[P] = true; // 최초 감염자 세팅

        // 악수 정보 입력
        List<HandShake> handShakes = new ArrayList<>();
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 악수한 시점 (t초)
            int x = Integer.parseInt(st.nextToken()); // 악수할 사람
            int y = Integer.parseInt(st.nextToken()); // 악수할 사람
            handShakes.add(new HandShake(t,x,y));
        }

        // 시간순으로 정렬
        Collections.sort(handShakes);

        // 악수 처리
        for (HandShake handShake : handShakes) {
            processHandShake(handShake, isInfected, infectionCountLeft);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(isInfected[i]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        System.out.println(sb);
    }

    // 악수 로직 처리 메서드
    private static void processHandShake(HandShake handShake, boolean[] isInfected, int[] infectionCountLeft) {
        int x = handShake.x;
        int y = handShake.y;

        if (isInfected[x] && !isInfected[y] && infectionCountLeft[x] > 0) {
            isInfected[y] = true;
            infectionCountLeft[x]--;
        } else if (isInfected[y] && !isInfected[x] && infectionCountLeft[y] > 0) {
            isInfected[x] = true;
            infectionCountLeft[y]--;
        } else if (isInfected[x] && isInfected[y]) {
            infectionCountLeft[x] = Math.max(0, infectionCountLeft[x] - 1);
            infectionCountLeft[y] = Math.max(0, infectionCountLeft[y] - 1);
        }
    }
}
