package lv1.조건문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장학금 {
    private static final int GRADE_A = 100000;
    private static final int GRADE_B = 50000;
    private static final int GRADE_C = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int midScore = Integer.parseInt(st.nextToken());
        int finalScore = Integer.parseInt(st.nextToken());

        if(midScore < 90) {
            System.out.println(GRADE_C);
            return;
        }

        if(finalScore >=95) {
            System.out.println(GRADE_A);
        } else if(finalScore >= 90) {
            System.out.println(GRADE_B);
        } else {
            System.out.println(GRADE_C);
        }
    }
}
