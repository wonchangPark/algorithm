package lv1.조건문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좀더어려운수학점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = "A";
        String B = "B";
        int mathScoreA = 0;
        int engScoreA = 0;
        int mathScoreB = 0;
        int engScoreB = 0;
        mathScoreA = Integer.parseInt(st.nextToken());
        engScoreA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        mathScoreB = Integer.parseInt(st.nextToken());
        engScoreB = Integer.parseInt(st.nextToken());

        String winner = null;
        if(mathScoreA != mathScoreB) {
            winner = mathScoreA > mathScoreB ? A : B;
            System.out.println(winner);
        } else {
            winner = engScoreA > engScoreB ? A : B;
            System.out.println(winner);
        }
    }
}
