package lv1.조건문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 굉장한숫자 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = Integer.parseInt(s);
        if((a % 2 == 1 && a%3==0) || (a % 2 == 0 && a%5==0)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
