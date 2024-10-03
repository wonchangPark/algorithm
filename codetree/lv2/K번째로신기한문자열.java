package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class K번째로신기한문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String T = st.nextToken();
        String[] baseArr = new String[n];

        for(int i=0; i<n; i++) {
            baseArr[i] = br.readLine();
        }

        List<String> arr = new ArrayList<>();
        for(String s : baseArr) {
            if(s.length()>=T.length() && s.startsWith(T)){
                arr.add(s);
            }
        }

        Collections.sort(arr);

        System.out.println(arr.get(k-1));
    }
}
