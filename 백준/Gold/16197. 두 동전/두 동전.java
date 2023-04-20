import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N,M;

    static class Position{
        Coin c1;
        Coin c2;
        int cnt;

        public Position(Coin c1, Coin c2, int cnt) {
            this.c1 = c1;
            this.c2 = c2;
            this.cnt = cnt;
        }
    }

    static class Coin{
        int r;
        int c;

        public Coin(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        char[][] board = new char[N][M];

        for(int i=0; i<N; i++){
            char[] temp2 = br.readLine().toCharArray();
            board[i] = temp2;
        }

        List<Coin> list= new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 'o'){
                    list.add(new Coin(i,j));
                }
            }
        }

        int ans = bfs(board, list, new boolean[N][M][N][M]);
        System.out.println(ans);
    }

    private static int bfs(char[][] board, List<Coin> list, boolean[][][][] check) {
        Queue<Position> queue = new LinkedList<>();
        Coin c1 = list.get(0);
        Coin c2 = list.get(1);
        queue.add(new Position(c1, c2, 0));
        check[c1.r][c1.c][c2.r][c2.c] = true;
        check[c2.r][c2.c][c1.r][c1.c] = true;

        while (!queue.isEmpty()){
            Position p = queue.poll();
            int cnt = p.cnt;
            for(int i=0; i<4; i++){
                Coin nc1 = new Coin(p.c1.r+dr[i] , p.c1.c+dc[i]);
                Coin nc2 = new Coin(p.c2.r+dr[i] , p.c2.c+dc[i]);

                if(cnt+1 > 10) break;
                if((nc1.r<0 || nc1.r>=N || nc1.c<0 || nc1.c>=M) && (nc2.r<0 || nc2.r>=N || nc2.c<0 || nc2.c>=M)) continue;
                if((nc1.r<0 || nc1.r>=N || nc1.c<0 || nc1.c>=M) || (nc2.r<0 || nc2.r>=N || nc2.c<0 || nc2.c>=M)) {
                    return cnt+1;
                }
                if(board[nc1.r][nc1.c] == '#'){
                    nc1 = p.c1;
                }
                if(board[nc2.r][nc2.c] == '#'){
                    nc2 = p.c2;
                }
                if(check[nc1.r][nc1.c][nc2.r][nc2.c]) continue;
                check[nc1.r][nc1.c][nc2.r][nc2.c] = true;
                check[nc2.r][nc2.c][nc1.r][nc1.c] = true;
                queue.add(new Position(nc1, nc2, cnt+1));
            }

        }
        return -1;
    }
}
