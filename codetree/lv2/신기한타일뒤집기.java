package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신기한타일뒤집기 {
    private static int START = 100000;
    private static int MAX = START*2+1;
    private static int GRAY = 0;
    private static int WHITE = 1;
    private static int BLACK = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[MAX];
        int now = START;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            now = flip(now, arr, x, direction);
        }

        int white = 0;
        int black = 0;
        for(int color : arr) {
            if(color == WHITE) {
                white++;
            } else if(color == BLACK) {
                black++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(white).append(" ").append(black);
        System.out.println(sb);
    }

    private static int flip(int now, int[] arr, int x, String direction) {
        if(direction.equals("R")) {
            for(int i=0; i<x; i++) {
                arr[now+i] = BLACK;
            }
            return now+x-1;
        } else {
            for(int i=0; i<x; i++) {
                arr[now-i] = WHITE;
            }
            return now-x+1;
        }
    }
}
