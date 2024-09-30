package lv1.조건문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의계절은 {
    /**
     *  월인지를 입력받아, 어떤 계절인지를 출력하는 프로그램을 작성해보세요.
     *  3~5월이 봄, 6~8월이 여름, 9~11월이 가을, 12~2월이 겨울이라 가정합니다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int m = Integer.parseInt(s);
        if(m<=2 || m>=12) {
            System.out.println("Winter");
        } else if(m >= 9) {
            System.out.println("Fall");
        } else if(m >= 6) {
            System.out.println("Summer");
        } else {
            System.out.println("Spring");
        }
    }
}
