package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 정렬된숫자위치알아내기 {
    static class Number {
        int num;
        int preLocation;
        int postLocation;

        public Number(int num, int preLocation, int postLocation) {
            this.num = num;
            this.preLocation = preLocation;
            this.postLocation = postLocation;
        }
    }

    static class NumberComparator implements Comparator<Number> {
        @Override
        public int compare(Number o1, Number o2) {
            if(o1.num == o2.num) {
                return o1.preLocation - o2.preLocation;
            }
            return o1.num - o2.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Number> map = new HashMap<>();
        List<Number> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            Number number = new Number(Integer.parseInt(st.nextToken()), i, 0);
            list.add(number);
            map.put(number.preLocation, number);
        }

        list.sort(new NumberComparator());
        for(int i=0; i<n; i++) {
            map.get(list.get(i).preLocation).postLocation = i+1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(map.get(i).postLocation).append(" ");
        }

        System.out.println(sb);
    }
}
