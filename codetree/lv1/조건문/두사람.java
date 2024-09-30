package lv1.조건문;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 두사람 {
    private static final boolean MALE = true;
    private static class Person {
        boolean sex;
        int age;

        public Person(int age, boolean sex) {
            this.age = age;
            this.sex = sex;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            Person person = new Person(Integer.parseInt(st.nextToken()), st.nextToken().equals("M"));
            list.add(person);
        }

        boolean result = true;
        for(Person person : list) {
            if(person.sex == MALE && person.age >= 19) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
