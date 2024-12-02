package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int num = getGCD(n, m);
        System.out.println(num);
    }

    private static int getGCD(int n, int m) {
        int maxNum = Math.min(n, m);
        int ans = 1;
        for(int i=1; i<=maxNum; i++) {
            if(n%i==0 && m%i==0) {
                ans = i;
            }
        }
        return ans;
    }
}
