package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 비오는날 {
    enum DayOfTheWeek {
        Mon, Tue, Wed, Thu, Fri, Sat, Sun
    }

    static class WeatherInformation {
        String date;
        DayOfTheWeek dayOfTheWeek;
        String weather;

        public WeatherInformation(String date, DayOfTheWeek dayOfTheWeek, String weather) {
            this.date = date;
            this.dayOfTheWeek = dayOfTheWeek;
            this.weather = weather;
        }

        @Override
        public String toString() {
            return date+" "+dayOfTheWeek+" "+weather;
        }
    }

    static class WeatherInformationComparator implements Comparator<WeatherInformation> {
        @Override
        public int compare(WeatherInformation o1, WeatherInformation o2) {
            String[] dates1 = o1.date.split("-");
            String[] dates2 = o2.date.split("-");
            for(int i=0; i<dates1.length; i++) {
                if(Integer.parseInt(dates1[i]) != Integer.parseInt(dates2[i])) {
                    return Integer.parseInt(dates1[i]) - Integer.parseInt(dates2[i]);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<WeatherInformation> list = new ArrayList<>();
        String baseWeather = "Rain";

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            DayOfTheWeek dayOfTheWeek = DayOfTheWeek.valueOf(st.nextToken());
            String weather = st.nextToken();
            if(weather.equals(baseWeather)) {
                WeatherInformation weatherInformation = new WeatherInformation(date, dayOfTheWeek, weather);
                list.add(weatherInformation);
            }
        }

        list.sort(new WeatherInformationComparator());

        System.out.println(list.get(0));
    }
}
