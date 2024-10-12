package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T를초과하는연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // t 값 보다 높은 연속된 수열 구하기
        int len = checkArr(arr, t);
        System.out.println(len);
    }

    private static int checkArr(int[] arr, int t) {
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > t) {
                cnt++;
            } else {
                cnt = 0;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
