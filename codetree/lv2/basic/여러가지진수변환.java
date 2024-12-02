package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 여러가지진수변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 10진수인 num 을 b진수로 바꾸기
        int newNum = getNewNumber(num, b);
        System.out.println(newNum);
    }

    private static int getNewNumber(int num, int b) {
        List<Integer> list = new ArrayList<>();
        while(num != 0) {
            list.add(num%b);
            num /= b;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--) {
            sb.append(list.get(i).toString());
        }
        return Integer.parseInt(sb.toString());
    }
}
