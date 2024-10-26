package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좌우로움직이는로봇 {
    private static final int OFFSET = 1000000;
    private static final int MAX = OFFSET * 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // A가 움직인 정보
        int m = Integer.parseInt(st.nextToken()); // B가 움직인 정보

        int[] distA = new int[MAX];
        int[] distB = new int[MAX];

        int now = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            now = writeHistory(distA, t, direction, now);
        }

    }

    private static int writeHistory(int[] distA, int t, String direction, int now) {
        return 0;
    }
}
