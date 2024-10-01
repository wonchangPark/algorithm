package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 두개이상의알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        if(isMoreThan2Alphabets(charArray)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isMoreThan2Alphabets(char[] charArray) {
        Set<Character> set = new HashSet<>();
        for (char c : charArray) {
            set.add(c);
        }
        return set.size() > 1;
    }
}
