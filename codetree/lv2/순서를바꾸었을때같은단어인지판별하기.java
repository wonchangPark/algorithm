package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 순서를바꾸었을때같은단어인지판별하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);

        boolean flag = true;
        if(word1.length != word2.length) {
            flag = false;
        } else {
            for(int i=0; i<word1.length; i++) {
                if(word1[i] != word2[i]){
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag?"Yes":"No");

    }
}
