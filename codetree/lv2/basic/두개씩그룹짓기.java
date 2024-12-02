package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두개씩그룹짓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n*2];
        for(int i=0; i<n*2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
        for(int i=0; i<n; i++) {
            int newValue = arr[i] + arr[n*2-1-i];
            answer = Math.max(answer, newValue);
        }

        System.out.println(answer);
    }
}
