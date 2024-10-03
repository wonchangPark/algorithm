package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * n개의 원소가 주어졌을 때, 처음에는 오름차순으로 정렬하여 출력하고, 그 다음에는 내림차순으로 정렬하여 출력하는 프로그램을 작성해보세요.
 */
public class 오름내림차순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        printArr(sb, arr);
        Arrays.sort(arr, Collections.reverseOrder());
        printArr(sb, arr);
        System.out.println(sb);
    }

    private static void printArr(StringBuilder sb, Integer[] arr) {
        for(int num : arr) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }
}
