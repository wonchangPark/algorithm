package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재귀함수를이용한최소공배수 {
    public static final int MAX_N = 10;
    public static int n;
    public static int[] arr = new int[MAX_N + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lcm = getLCMAll(n);
        System.out.println(lcm);
    }

    private static int getLCMAll(int index) {
        if(index == 1) {
            return arr[1];
        }
        return getLCM(getLCMAll(index-1), arr[index]);
    }

    private static int getGCD(int n, int m) {
        if(m==0) return n;
        return getGCD(m, n%m);
    }

    private static int getLCM(int n, int m) {
        return n * m / getGCD(n,m);
    }
}
