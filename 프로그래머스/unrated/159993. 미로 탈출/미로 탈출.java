import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    static class Pair {
    	int r;
        int c;
        int cnt;
        
        public Pair(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] maps) {
        int R = maps.length;
        int C = maps[0].length();
        char[][] map = new char[R][C];
        int sr = 0;
        int sc = 0;
        int lr = 0;
        int lc = 0;
        int er = 0;
        int ec = 0;
        for(int i=0; i<R; i++){
            map[i] = maps[i].toCharArray();
            for(int j=0; j<C; j++){
                if(map[i][j] == 'S'){
                    sr = i;
                    sc = j;
                } else if(map[i][j] == 'L'){
                    lr = i;
                    lc = j;
                } else if(map[i][j] == 'E'){
                    er = i;
                    ec = j;
                } 
            }
        }
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        int answer = 0;
        System.out.println(sr + " "+ sc);
        System.out.println(lr+ " "+ lc);
        System.out.println(er + " "+ ec);
        
        // S -> L 로 가는 최단 경로 찾기
        int stol = bfs(map, R, C, sr, sc, lr, lc, new boolean[R][C]);
        System.out.println(stol);
        // L -> E 로 가는 최단 경로 찾기
        int ltoe = bfs(map, R, C, lr, lc, er, ec, new boolean[R][C]);
        System.out.println(ltoe);
        
        answer = stol + ltoe;
        if(stol == 0 || ltoe == 0) answer = -1;
        
        return answer;
    }
    
    public int bfs(char[][] map, int R, int C, int startR , int startC, int endR, int endC, boolean[][] check){
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startR, startC, 0));
        check[startR][startC] = true;
        
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.r == endR && p.c == endC){
                return p.cnt;
            }
            for(int i=0; i<4; i++){
            	int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                
                if(nr<0 || nr>=R || nc<0 || nc>=C || check[nr][nc] || map[nr][nc]=='X') continue;
                check[nr][nc] = true;
                queue.add(new Pair(nr, nc, p.cnt+1));
             
            }
        }
        
        return 0;
        
        
        
    }
}