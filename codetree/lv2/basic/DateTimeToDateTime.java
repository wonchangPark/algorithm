package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DateTimeToDateTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int baseA = 11;
        int baseB = 11;
        int baseC = 11;

        int ans = 0;
        ans = (a - baseA) * 24 * 60 + (b - baseB) * 60 + (c - baseC);
        if(ans < 0) ans = -1;
        System.out.println(ans);
    }
}
