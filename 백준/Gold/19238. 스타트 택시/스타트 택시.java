import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M, startR, startC, gas;

    static class Pair{
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Position{
        int r;
        int c;
        int dist;

        public Position(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken()) - 1;
        startC = Integer.parseInt(st.nextToken()) - 1;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int departR = Integer.parseInt(st.nextToken()) - 1;
            int departC = Integer.parseInt(st.nextToken()) - 1;
            int arriveR = Integer.parseInt(st.nextToken()) - 1;
            int arriveC = Integer.parseInt(st.nextToken()) - 1;
            map[departR][departC] = 2;
            hashMap.put(departR*100+departC, arriveR*100+arriveC);
        }

        int cnt = 0;
        while(true){
            if(cnt == M) break;
            // 손님 태우기
            pickUp(map);
            if(gas < 0){
                System.out.println(-1);
                return;
            }
            map[startR][startC] = 0;

            // 손님 목적지에 데려다주기
            dropOff(map, hashMap);
            if(gas < 0){
                System.out.println(-1);
                return;
            }

            cnt++;
        }

        System.out.println(gas);

    }

    private static void pickUp(int[][] map) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startR, startC, 0));
        int chosenR = Integer.MAX_VALUE; // 같은 dist 중에서 가장 작은 행을 고르기 위해
        int chosenC = Integer.MAX_VALUE; // 같은 chosenR이면 그 중 가장 작은 열을 고르기 위해
        int chosenDist = Integer.MAX_VALUE;

        if(map[startR][startC] == 2) {
            return;
        }
        boolean[][] check = new boolean[N][N];
        check[startR][startC] = true;
        while (!queue.isEmpty()){
            Position position = queue.poll();
            for(int i=0; i<4; i++){
                int nr = position.r + dr[i];
                int nc = position.c + dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=N || check[nr][nc] || map[nr][nc]==1) continue;
                check[nr][nc] = true;
                if(chosenDist != Integer.MAX_VALUE){
                    if(map[nr][nc] != 2) continue;
                    if(position.dist+1 == chosenDist){
                        if(nr < chosenR){
                            chosenR = nr;
                            chosenC = nc;
                        } else if(nr == chosenR){
                            if(nc < chosenC){
                                chosenC = nc;
                            }
                        }
                    }
                } else{
                    if(map[nr][nc] != 2){
                        queue.add(new Position(nr, nc, position.dist + 1));
                        continue;
                    }
                    chosenDist = position.dist + 1;
                    chosenR = nr;
                    chosenC = nc;
                }
            }
        }
        startR = chosenR;
        startC = chosenC;
        gas -= chosenDist;

    }

    private static void dropOff(int[][] map, Map<Integer,Integer> hashMap) {
        // 목적지가 벽에 둘려쌓여 못가는 경우도 생각을 해야 한다.
        int value = hashMap.get(startR*100+startC);
        int arriveR = value/100;
        int arriveC = value%100;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startR, startC, 0));
        boolean[][] check = new boolean[N][N];
        check[startR][startC] = true;
        while (!queue.isEmpty()){
            Position position = queue.poll();
            for(int i=0; i<4; i++){
                int nr = position.r + dr[i];
                int nc = position.c + dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=N || check[nr][nc] || map[nr][nc]==1) continue;
                if(gas - position.dist - 1 < 0) continue;
                if(nr == arriveR && nc == arriveC) {
                    startR = arriveR;
                    startC = arriveC;
                    gas += (position.dist+1);
                    return;
                }
                check[nr][nc] = true;
                queue.add(new Position(nr, nc, position.dist+1));
            }

        }

        gas = -1;

    }
}
