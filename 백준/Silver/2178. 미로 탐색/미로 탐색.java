import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Position{
        int n;
        int m;
        int cnt;

        public Position(int n, int m, int cnt) {
            this.n = n;
            this.m = m;
            this.cnt = cnt;
        }

        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
        public int getM() { return m; }
        public void setM(int m) { this.m = m; }
        public int getCnt() { return cnt; }
        public void setCnt(int cnt) { this.cnt = cnt; }
    }

    static int[] dn = {0, 1, 0, -1};
    static int[] dm = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Position> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        boolean[][] checkBoard = new boolean[N][M];

        for(int i=0; i<N; i++){
            board[i] = br.readLine().toCharArray();
        }

        queue.add(new Position(0,0,1));
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Position position = queue.poll();
            int n = position.getN();
            int m = position.getM();
            int cnt = position.getCnt();

            for(int i=0; i<dn.length; i++){ // 4방향 모두 가보기
                int nn = n + dn[i];
                int nm = m + dm[i];
                if(nn<0 || nn>N-1 || nm<0 || nm>M-1 || board[nn][nm]=='0' || checkBoard[nn][nm]) continue;
                checkBoard[nn][nm] = true;
                if(nn==N-1 && nm==M-1){
                    ans = cnt+1;
                } else {
                    queue.add(new Position(nn, nm, cnt+1));
                }

            }

        }

        System.out.println(ans);

    }
}
