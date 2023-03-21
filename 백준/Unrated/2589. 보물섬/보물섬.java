import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int R,C;
    static int maxLen = 0;
    static boolean[][] island;

    static class Pair{
        int r;
        int c;
        int len;

        public Pair(int r, int c, int len) { this.r = r; this.c = c; this.len = len;}

        public int getR() { return r; }
        public void setR(int r) { this.r = r; }
        public int getC() { return c; }
        public void setC(int c) { this.c = c; }
        public int getLen() { return len; }
        public void setLen(int len) { this.len = len; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        R = Integer.parseInt(temp[0]); // 세로의 크기
        C = Integer.parseInt(temp[1]); // 가로의 크기

        island = new boolean[R][C];

        for(int i=0; i<R; i++){
            String temp2 = br.readLine();
            for(int j=0; j<C; j++){
                char c = temp2.charAt(j);
                if(c == 'L'){ // 육지
                    island[i][j] = true;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!island[i][j]){
                    continue;
                }

                // 육지이므로 bfs를 시작
                bfs(i, j, new boolean[R][C]);
                if(ans < maxLen) {
                    ans = maxLen;
                }
                maxLen = 0;
            }
        }

        System.out.println(ans);

    }

    private static void bfs(int tempR, int tempC, boolean[][] check) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(tempR,tempC,0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.getR();
            int c = pair.getC();
            int len = pair.getLen();
            check[r][c] = true;
            if(maxLen < len) maxLen = len;

            for(int i=0; i<dr.length; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr<0 || nr>=R || nc<0 || nc>=C || check[nr][nc] || !island[nr][nc]) continue;

                check[nr][nc] = true;
                queue.add(new Pair(nr, nc, len+1));

            }
        }


    }

}
