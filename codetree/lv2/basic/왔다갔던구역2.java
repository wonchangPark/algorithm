package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 왔다갔던구역2 {

    private static final int START = 1000;
    private static final int MAX = 2000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[MAX];
        int now = START;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            now = move(now, x, direction, arr);
        }

        // 2번 이상 이동한 영역 크기 계산
        int cnt = 0;
        for(int i=0; i<MAX; i++) {
            if(arr[i] >= 2) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static int move(int now, int x, String direction, int[] arr) {
        if(direction.equals("R")) {
            for(int i=0; i<x; i++) {
                arr[now+i]++;
            }
            return now+x;
        } else {
            for(int i=1; i<=x; i++) {
                arr[now-i]++;
            }
            return now-x;
        }
    }
}
