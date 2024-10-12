package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선두를지켜라 {

    private static final int A = 1;
    private static final int B = 2;

    public static final int MAX_T = 1000000;

    public static int n, m;
    public static int[] posA = new int[MAX_T + 1];
    public static int[] posB = new int[MAX_T + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 각각의 시간마다의 이동한 총 거리를 기록한다.
        addDistance(posA, n, br);
        addDistance(posB, m, br);

        // 경주 시작
        int cnt = 0;
        int winning = 0;
        for(int i=0; i<posA.length; i++) {
            if(posA[i] > posB[i] && (winning == B || winning == 0)) {
                winning = A;
                cnt++;
            } else if(posA[i] < posB[i] && (winning == A || winning == 0)) {
                winning = B;
                cnt++;
            }
        }

        System.out.println(cnt-1);
    }

    static private void addDistance(int[] list, int num, BufferedReader br) throws IOException {

        int time = 1;
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            while(t-- > 0) {
                list[time] = list[time - 1] + v;
                time++;
            }
        }
    }
}
