package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요일맞추기 {
    private static final String[] DayOfTheWeek = {
        "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
    };

    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        // m1 월 d1 일 은 월요일
        // 먼저 m1 d1 의 총 일수를 구한다.
        int totalDayOfOne = getTotalDay(m1, d1);
        int totalDayOfTwo = getTotalDay(m2, d2);
        String ans = null;
        if(totalDayOfOne >= totalDayOfTwo) {
            int day = (totalDayOfOne - totalDayOfTwo) % DayOfTheWeek.length;
            ans = day == 0 ? DayOfTheWeek[day] : DayOfTheWeek[Math.abs(day - DayOfTheWeek.length)];
        } else {
            int day = totalDayOfTwo - totalDayOfOne;
            ans = DayOfTheWeek[day % DayOfTheWeek.length];
        }
        System.out.println(ans);
    }

    private static int getTotalDay(int m2, int d2) {
        int totalDay = 0;
        for(int i=1; i<m2; i++) {
            totalDay += DAYS_IN_MONTH[i];
        }
        totalDay += d2;
        return totalDay;
    }
}
