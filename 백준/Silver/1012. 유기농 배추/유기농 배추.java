import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static final int DIRECTION = 4;
    static int N;
    static int M;

    static class Pair{
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() { return r; }
        public void setR(int r) { this.r = r; }
        public int getC() { return c; }
        public void setC(int c) { this.c = c; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String[] temp = br.readLine().split(" ");
            M = Integer.parseInt(temp[0]); // 가로길이
            N = Integer.parseInt(temp[1]); // 세로길이
            int K = Integer.parseInt(temp[2]); // 배추의 개수

            boolean[][] map = new boolean[N][M];
            for(int i=0; i<K; i++){
                String[] temp2 = br.readLine().split(" ");
                int m = Integer.parseInt(temp2[0]);
                int n = Integer.parseInt(temp2[1]);

                map[n][m] = true; // 배추가 심어진 자리
            }

            boolean[][] check = new boolean[N][M];
            int ans = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(!check[i][j] && map[i][j]){
                        bfs(map, check, i, j);
                        ans++;
                    }

                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs(boolean[][] map, boolean[][] check, int r, int c) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c));

        while(!queue.isEmpty()){
            Pair now = queue.poll();
            for(int i=0; i<DIRECTION; i++){
                int nr = now.getR() + dr[i];
                int nc = now.getC() + dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=M || check[nr][nc] || !map[nr][nc]) continue;
                check[nr][nc] = true;
                queue.add(new Pair(nr,nc));
            }
        }
    }
}
