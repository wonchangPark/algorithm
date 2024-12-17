package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마라톤 코스는 N개의 체크포인트로 구성되어 있으며, 1번 체크포인트에서 시작해서 모든 체크 포인트를 순서대로 방문한 후 N번 체크포인트에서 마라톤이 끝납니다.
 * 게으른 개발자 A는 막상 대회에 참가하려 하니 귀찮아져서 중간에 있는 체크포인트 한 개를 몰래 건너뛰려 합니다.
 * 단, 1번 체크포인트와 N번 체크포인트를 건너뛰면 티가 많이 나기 때문에 이 두 체크포인트는 건너뛰지 않으려고 합니다.
 * 개발자 A가 체크포인트 한 개를 건너 뛰어서 마라톤을 완주하려고 할 때, 최소 거리를 구하는 프로그램을 작성해보세요.
 * 단, 거리 계산은 택시 거리(Manhattan Distance)를 이용합니다.
 * 택시거리란 (x1,y1) 과 (x2,y2) 지점 간의 거리를 ∣x1 - x2| + |y1 - y2| 로 계산하는 것을 의미합니다.
 * 또한, 체크 포인트의 좌표는 겹쳐져 주어질 수도 있으며,
 * 이 경우 개발자 A가 체크포인트를 건너뛸 때 그 번호의 체크포인트만 건너뛰게 되며 그 점에 있는 모든 체크포인트를 건너뛰지 않음에 유의합니다.
 *
 * 입력 형식
 * 첫 번째 줄에 체크포인트 N이 주어집니다.
 * 이후 N개의 줄에 걸쳐 한 줄에 하나씩 각 번호에 해당하는 지점의 위치 (x, y)가 공백을 사이에 두고 주어집니다.
 * 3 ≤ N ≤ 100
 * -1,000 ≤ x, y ≤ 1,000
 */

public class 마라톤중간에택시타기2 {

    static int N;
    static int[] arrX;
    static int[] arrY;
    static int OFFSET = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrX = new int[N];
        arrY = new int[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrX[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            arrY[i] = Integer.parseInt(st.nextToken()) + OFFSET;
        }

        int minDist = Integer.MAX_VALUE;
        int exclusiveNum = 1;
        while (exclusiveNum < N) {
            int tempDist = 0;
            int nowX = arrX[0];
            int nowY = arrY[0];
            for(int i=1; i<N; i++) {
                if(exclusiveNum == i) {
                    continue;
                }
                int newX = arrX[i];
                int newY = arrY[i];
                tempDist += (Math.abs(newX - nowX) + Math.abs(newY - nowY));
                nowX = newX;
                nowY = newY;
            }
            minDist = Math.min(minDist, tempDist);
            exclusiveNum++;
        }

        System.out.println(minDist);

    }
}
