package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 사는지역 {
    static class Person implements Comparable<Person> {
        String name;
        String addr;
        String city;

        public Person(String name, String tel, String region) {
            this.name = name;
            this.addr = tel;
            this.city = region;
        }

        @Override
        public int compareTo(Person o) {
            return o.name.compareTo(this.name);
        }

        @Override
        public String toString() {
            return "name " + name + '\n' +
                    "addr " + addr + '\n' +
                    "city " + city + '\n';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            Person person = new Person(st.nextToken(), st.nextToken(), st.nextToken());
            list.add(person);
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
