package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 십진수로변환하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] digits = new int[chars.length];
        for(int i=0; i<digits.length; i++) {
            digits[i] = Character.getNumericValue(chars[i]);
        }

        int n = getNumber(digits);
        System.out.println(n);
    }

    private static int getNumber(int[] digits) {
        int n = 0;
        for (int digit : digits) {
            n = (n * 2 + digit);
        }
        return n;
    }
}
