package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그계절그날 {
    /**
     * 연도, 월, 일이 차례로 3개의 정수 Y, M, D로 주어졌을 때,
     * Y 해에 M월 D일이 존재한다면 어떤 계절인지를 출력하고,
     * 만약 존재하지 않는다면 -1을 출력하는 프로그램을 작성해보세요. 단, 함수를 이용하여 문제를 해결해주세요.
     * 3~5월이 봄, 6~8월이 여름, 9~11월이 가을, 12~2월이 겨울이라 가정합니다.
     * 단, 윤년(2월이 29일까지 있는 해)의 조건은 다음과 같습니다.
     * <p>
     * 4의 배수라면 윤년입니다.
     * 4의 배수이면서 100의 배수라면 윤년이 아닙니다.
     * 4의 배수이면서 100의 배수지만 또한 400의 배수라면 윤년입니다.
     * 나머지 경우에는 윤년이 아닙니다.
     */
    private static final String SPRING = "Spring";
    private static final String SUMMER = "Summer";
    private static final String FALL = "Fall";
    private static final String WINTER = "Winter";

    // 월별 일수 배열, 윤년 여부에 따라 2월은 수정 가능
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (!isDayExists(Y, M, D)) {
            System.out.println(-1);
        } else {
            getSeason(M);
        }
    }

    // 계절을 출력하는 메서드
    private static void getSeason(int m) {
        if (m == 12 || m <= 2) {
            System.out.println(WINTER);
        } else if (m <= 5) {
            System.out.println(SPRING);
        } else if (m <= 8) {
            System.out.println(SUMMER);
        } else {
            System.out.println(FALL);
        }
    }

    private static boolean isDayExists(int y, int m, int d) {
        if (m < 1 || m > 12) return false;

        if (isLeapYear(y)) {
            DAYS_IN_MONTH[1] = 29;
        } else {
            DAYS_IN_MONTH[1] = 28;
        }

        return d >= 1 && d <= DAYS_IN_MONTH[m - 1];
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }
}
