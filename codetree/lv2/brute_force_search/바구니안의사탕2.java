package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바구니안의사탕2 {
    private static int N,K;
    private static int[] arr;
    private static final int ARR_SIZE = 101;
    public static void main(String[] args) throws IOException {
        read();

        // sliding window
        // K 가 전체 배열길이보다 클 수 있음
        int value = 0;
        for(int j=0; j<K*2+1; j++) {
            if(j >= ARR_SIZE) break;
            value += arr[j];
        }

        int ans = value;
        for(int i=1; i<ARR_SIZE-K*2; i++) {
            int newValue = value - arr[i-1] + arr[i+K*2];
            ans = Math.max(ans, newValue);
            value = newValue;
        }

        System.out.println(ans);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[ARR_SIZE];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int candies = Integer.parseInt(st.nextToken()); // 사탕의 개수
            int spot = Integer.parseInt(st.nextToken()); // 바구니 위치
            arr[spot] += candies;
        }
    }
}
