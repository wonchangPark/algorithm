package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 중앙값계산2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb  = new StringBuilder();
        for(int i=1; i<=n; i++) {
            if(i%2==1) {
                Arrays.sort(arr, 1, i+1);
                int midNum = (1+i)/2;
                sb.append(arr[midNum]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
