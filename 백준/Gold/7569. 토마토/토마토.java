import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Position{
        int r;
        int c;
        int h;
        int day;

        public Position(int r, int c, int h, int day) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }

        public int getR() { return r; }
        public void setR(int r) { this.r = r; }
        public int getC() { return c; }
        public void setC(int c) { this.c = c; }
        public int getH() { return h; }
        public void setH(int h) { this.h = h; }
        public int getDay() { return day; }
        public void setDay(int day) { this.day = day; }
    }

    static int[] dr = {0,1,0,-1,0,0};
    static int[] dc = {1,0,-1,0,0,0};
    static int[] dh = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // c 가로
        int N = Integer.parseInt(st.nextToken()); // r 세로
        int H = Integer.parseInt(st.nextToken()); // h 높이

        int[][][] box = new int[N][M][H];
        boolean[][][] check = new boolean[N][M][H];
        int unripe = 0;
        // 익은 토마토 큐에 넣기 + 익지 않은 토마토의 개수 세기
        Queue<Position> queue = new LinkedList<>();
        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    int num = Integer.parseInt(st.nextToken());
                    box[i][j][h] = num;
                    if(num == 1){
                        queue.add(new Position(i, j, h, 0));
                        check[i][j][h] = true;
                    } else if(num == 0){
                        unripe++;
                    }
                }
            }
        } // box 완성

        int day = 0;
        // day가 지나면서 토마토가 익는 과정
        while(!queue.isEmpty()){
            Position now = queue.poll();
            int r = now.getR();
            int c = now.getC();
            int h = now.getH();

            for(int i=0; i<6; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                int nh = h + dh[i];
                // 상하좌우위아래의 토마토를 보고 이미 전에 익어서 체크가 되어있던가 토마토가 들어있지 않다면 패스
                // 또한 경계도 체크해준다. box의 r,c,h의 경계를 넘지 않아야 arrayindexbound 에러가 안뜸
                if(nr<0 || nr>=N || nc<0 || nc>=M || nh<0 || nh>=H || check[nr][nc][nh] || box[nr][nc][nh] == -1) continue;
                // 이제 익지 않은 토마토이므로 이것은 익었다고 하고 day+1을 한 토마토를 큐에 넣는다.
                check[nr][nc][nh] = true;
                queue.add(new Position(nr,nc,nh, now.getDay()+1));
                if(day < now.getDay()+1) day = now.getDay() + 1;
                unripe--;
            }
        }

        // box 전체를 훑어서 아직 익지 않은 토마토가 있는 지 확인
        if(unripe!=0) day = -1;

        System.out.println(day);
    }
}
