import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static class Position{
        int r;
        int c;
        int value;
        int cnt;
        int len;

        public Position(int r, int c, int value, int cnt, int len) {
            this.r = r;
            this.c = c;
            this.value = value;
            this.cnt = cnt;
            this.len = len;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = 0;
        int k = 1;
        int r = 0;
        int c = 0;
        for(int i=0; i<3; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                int n = Integer.parseInt(temp[j]);
                if(n == 0) {
                    r = i;
                    c = j;
                }
                value += (n*k);
                k *= 10;
            }
        }
        if(value == 87654321){
            System.out.println(0);
            return;
        }

        Set<Integer> set = new HashSet<>(); // check를 위해
        set.add(value);

        Queue<Position> queue = new LinkedList<>();
        int tNum = 1;
        int ttr = r;
        int ttc = c;
        while(ttr-->0){
            tNum *= 1000;
        }
        while (ttc-->0){
            tNum *= 10;
        }
        queue.add(new Position(r, c, value, 0, tNum));
        while(!queue.isEmpty()){
            Position p = queue.poll();
            for(int i=0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                int tempValue = p.value;
                if(nr<0 || nr>=3 || nc<0 || nc>=3) continue;
                int num = 1;
                int tr = nr;
                int tc = nc;
                while(tr-->0){
                    num *= 1000;
                }
                while(tc-->0){
                    num *= 10;
                }
                int nn = (tempValue%(num*10))/num; // 새로 이동한 자리의 값
                int nValue = tempValue - nn*num + nn*p.len;
                if(nValue == 87654321){
                    System.out.println(p.cnt+1);
                    return;
                }
                if(set.contains(nValue)) continue;
                set.add(nValue);
                queue.add(new Position(nr, nc, nValue, p.cnt+1, num));
            }
        }
        System.out.println(-1);
    }
}
