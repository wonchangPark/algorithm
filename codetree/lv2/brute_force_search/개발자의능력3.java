package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 개발자의능력3 {
    private static int[] arr;
    private static final int ARR_SIZE = 6;
    public static void main(String[] args) throws IOException {
        read();

        int minDiff = Integer.MAX_VALUE;
        int sum = Arrays.stream(arr).sum();
        for(int i=0; i<ARR_SIZE; i++) {
            for(int j=i+1; j<ARR_SIZE; j++) {
                for(int k=j+1; k<ARR_SIZE; k++) {
                    minDiff = Math.min(minDiff, calculateDiff(i, j, k, sum));
                }
            }
        }

        System.out.println(minDiff);
    }

    private static int calculateDiff(int i, int j, int k, int sum) {
        int teamA = arr[i] + arr[j] + arr[k];
        int teamB = sum - teamA;
        return Math.abs(teamA - teamB);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[ARR_SIZE];
        for(int i=0; i<ARR_SIZE; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
