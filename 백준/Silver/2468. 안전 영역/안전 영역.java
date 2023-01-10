import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static class Position{
        int r;
        int c;

        public Position(int r, int c) {
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
        int N = Integer.parseInt(br.readLine()); // 전체 영역의 길이
        int[][] map = new int[N][N];
        int H = 0; // 가장 높은 곳
        for(int i=0; i<N; i++){
            String[] words = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(words[j]);
                if(H < num) H = num;
                map[i][j] = num;
            }
        } // map 완성

        int ans = 1; // 물의 높이가 0일 때 모든 부분은 안전하다.
        for(int h=1; h<H; h++){
            int safeAreaNum = findSafeAreaNum(map, h);
            if(ans < safeAreaNum) ans = safeAreaNum;
        }

        System.out.println(ans);
    }

    public static int findSafeAreaNum(int[][] map, int h){
        int N = map.length;
        boolean[][] check = new boolean[N][N];
        int areaNum = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(check[i][j] || map[i][j]<=h) continue;
                bfs(map, check, i, j, h);
                areaNum++;
            }
        }

        return areaNum;
    }

    public static void bfs(int[][] map, boolean[][] check, int r, int c, int h){
        int N = map.length;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(r,c));
        while(!queue.isEmpty()){
            Position position = queue.poll();
            for(int i=0; i<dr.length; i++){
                int nr = position.getR() + dr[i];
                int nc = position.getC() + dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]<=h || check[nr][nc]) continue;
                check[nr][nc] = true;
                queue.add(new Position(nr, nc));
            }
        }


    }
}
