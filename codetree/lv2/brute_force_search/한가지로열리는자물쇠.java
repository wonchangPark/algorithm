package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한가지로열리는자물쇠 {
    private static int N,a,b,c;
    public static void main(String[] args) throws IOException {
        read();

        int totalCnt = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                for(int k=1; k<=N; k++) {
                    if(Math.abs(a - i) > 2  && Math.abs(b - j) > 2 && Math.abs(c - k) > 2) continue;
                    totalCnt++;
                }
            }
        }

        System.out.println(totalCnt);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }
}
