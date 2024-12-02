package lv2.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 흰검칠하기 {
    static class Tile {
        int cntBlack;
        int cntWhite;
        Color color;

        public Tile (int cntBlack, int cntWhite, Color color) {
            this.cntBlack = cntBlack;
            this.cntWhite = cntWhite;
            this.color = color;
        }

        public Tile() {
            this(0,0,Color.NULL);
        }

        public void plusBlack(){
            this.cntBlack++;
            this.color = Color.BLACK;
            isGray();
        }

        public void plusWhite(){
            this.cntWhite++;
            this.color = Color.WHITE;
            isGray();
        }

        private void isGray() {
            if(this.cntWhite >= 2 && this.cntBlack >= 2){
                this.color = Color.GRAY;
            }
        }
    }

    enum Color {
        NULL, BLACK, WHITE, GRAY
    }

    private static int START = 100000;
    private static int MAX = 200000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tile[] arr = new Tile[MAX];
        int now = START;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            now = move(now, arr, x, direction);
        }

        // 개수 세기
        int black = 0;
        int white = 0;
        int gray = 0;
        for(Tile tile : arr) {
            if(tile == null) continue;
            if(tile.color == Color.BLACK) {
                black++;
            } else if(tile.color == Color.WHITE) {
                white++;
            } else if(tile.color == Color.GRAY) {
                gray++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(white).append(" ").append(black).append(" ").append(gray);
        System.out.println(sb);

    }

    private static int move(int now, Tile[] arr, int x, String direction){
        if(direction.equals("R")) {
            for(int i=0; i<x; i++) {
                if(arr[now+i] == null) {
                    arr[now+i] = new Tile();
                }
                arr[now+i].plusBlack();
            }
            return now + x - 1;
        } else {
            for(int i=0; i<x; i++) {
                if(arr[now-i] == null) {
                    arr[now-i] = new Tile();
                }
                arr[now-i].plusWhite();
            }
            return now - x + 1;
        }
    }
}
