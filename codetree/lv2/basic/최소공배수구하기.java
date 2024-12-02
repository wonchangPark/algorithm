package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 최소공배수는 n*m / (n과m의 최대공약수)
        int gcd = getGCD(n, m);
        int lcm = n*m/gcd;
        System.out.println(lcm);
    }

    private static int getGCD(int n, int m) {
        while (m!=0) {
            int temp = m;
            m = n%m;
            n = temp;
        }
        return n;
    }
}
