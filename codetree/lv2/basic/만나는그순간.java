package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 만나는그순간 {

    private static final int OFFSET = 1000 * 1000;
    private static final int MAX = OFFSET*2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] arrA = new int[MAX+1+1];
        int[] arrB = new int[MAX+1+1];

        int timeA = 1;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            for(int j=0; j<dist; j++) {
                arrA[timeA+j] = dir.equals("R") ? 1 : -1;
            }
            timeA += dist;
        }

        int timeB = 1;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            for(int j=0; j<dist; j++) {
                arrB[timeB+j] = dir.equals("R") ? 1 : -1;
            }
            timeB += dist;
        }

        int time = 1;
        int nowA = OFFSET;
        int nowB = OFFSET;
        int ans = -1;

        while (true) {
            if(arrA[time] == 0 || arrB[time] == 0) {
                break;
            }
            nowA += arrA[time];
            nowB += arrB[time];
            if(nowA == nowB) {
                ans = time;
                break;
            }
            time++;
        }

        System.out.println(ans);
    }
}
