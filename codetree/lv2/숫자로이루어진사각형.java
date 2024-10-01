package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자로이루어진사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        printNumber(N, N, sb);
        System.out.println(sb);
    }

    private static void printNumber(int rowNum, int colNum, StringBuilder sb) {
        int num = 1;
        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                sb.append(num++).append(" ");
                if(num>=10) {
                   num /= 10;
                }
            }
            sb.append("\n");
        }
    }
}
