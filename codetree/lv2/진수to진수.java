package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 진수to진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(br.readLine());

        n = getNumberByBinary(n, a);
        n = getNumberToBinary(n, b);
        System.out.println(n);
    }

    private static long getNumberToBinary(long n, int b) {
        // 10 진수인 n 을 b 진수로 바꾸기
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add((int) (n%b));
            n /= b;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--) {
            sb.append(list.get(i));
        }
        return Long.parseLong(sb.toString());
    }

    private static int getNumberByBinary(long n, int a) {
        // a 진수인 값 n 을 십진수로 바꾸기
        int newNum = 0;
        String num = String.valueOf(n);
        for(int i=0; i<num.length(); i++){
            newNum = (newNum * a) + Character.getNumericValue(num.charAt(i));
        }

        return newNum;
    }
}
