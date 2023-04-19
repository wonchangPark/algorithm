import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] board;
    static class Position{
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static class PositionA{
        int r;
        int c;
        int arrow;

        public PositionA(int r, int c, int arrow) {
            this.r = r;
            this.c = c;
            this.arrow = arrow;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i=0; i<N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                board[i][j] = temp[j].charAt(0);
            }
        }

        List<Position> list = new ArrayList<>();
        List<Position> teachers = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 'X'){
                    list.add(new Position(i,j));
                } else if(board[i][j] == 'T'){
                    teachers.add(new Position(i,j));
                }
            }
        }

        boolean[] check = new boolean[list.size()];
        if(selectThreeWall(list, teachers, check, 0, 0)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }


    }

    private static boolean selectThreeWall(List<Position> list, List<Position> teachers, boolean[] check, int cnt, int num) {
        // 이 곳에서는 3개의 장애물을 선택한다.
        if(cnt == 3){
            // 3개가 정해졌으므로 이제 학생을 모두 숨길 수 있는지 체크
            for(int i=0; i<list.size(); i++){
                if(check[i]){
                    Position p = list.get(i);
                    board[p.r][p.c] = 'W';
                }
            }
            if(isPossible(teachers)){
                return true;
            }

            for(int i=0; i<list.size(); i++){
                if(check[i]){
                    Position p = list.get(i);
                    board[p.r][p.c] = 'X';
                }
            }
            return false;
        }

        for(int i=num; i<list.size(); i++){
            check[i] = true;
            if(selectThreeWall(list, teachers, check, cnt+1, i+1)){
                return true;
            }
            check[i] = false;
        }
        return false;
    }

    private static boolean isPossible(List<Position> teachers) {
        Queue<PositionA> queue = new LinkedList<>();
        for(Position teacher : teachers){
            for(int i=0; i<4; i++){
                queue.add(new PositionA(teacher.r, teacher.c, i));
            }
        }

        while(!queue.isEmpty()){
            PositionA p = queue.poll();
            int nr = p.r + dr[p.arrow];
            int nc = p.c + dc[p.arrow];
            if(nr<0 || nr>=N || nc<0 || nc>=N || board[nr][nc]=='W') continue;
            if(board[nr][nc] == 'S') {
                return false;
            }
            queue.add(new PositionA(nr, nc, p.arrow));
        }

        return true;
    }
}
