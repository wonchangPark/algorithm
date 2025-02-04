package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GOrH2 {

    private static final int ARR_SIZE = 101;
    private static int N;
    private static char[] arr;
    public static void main(String[] args) throws IOException {
        read();

        // 오로지 G 혹은 H 만 사진에 나오거나
        // G 와 H 의 개수가 정확히 같으면 좋다.
        int ans = 0;
        for(int i=0; i<ARR_SIZE; i++) {
            if(arr[i] == '\u0000') continue;
            for(int j=i; j<ARR_SIZE; j++) {
                if(arr[j] == '\u0000') continue;
                // i 부터 j 까지
                int countG = 0;
                int countH = 0;
                for(int k=i; k<=j; k++) {
                    if(arr[k] == 'G') {
                        countG++;
                    } else if(arr[k] == 'H') {
                        countH++;
                    }
                }
                if(countH==0 || countG==0 || (countG == countH)) {
                    int dist = j-i;
                    ans = Math.max(ans, dist);
                }
            }
        }

        System.out.println(ans);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[ARR_SIZE];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }
    }
}
