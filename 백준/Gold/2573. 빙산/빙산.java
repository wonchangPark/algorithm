import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] zeroCnt = new int[N][M]; // 4방향으로 0이 몇개인지 체크한 곳
        int highest = 0;
        for(int i=0; i<N; i++){
            String[] words = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(words[j]);
                if(highest < map[i][j]) highest = map[i][j];
            }
        } // map 완성

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int cnt = 0;
                for(int k=0; k<dr.length; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                    if(map[nr][nc] == 0) cnt++;
                }
                zeroCnt[i][j] = cnt;
            }
        } // 0이 몇개인지 체크하는 배열 완성

        int year = 0;
        
        while(true) {

            // 빙하를 녹였으면 dfs를 통해 2개 이상의 덩어리로 나뉘어졌는지 확인
            // 만약 나뉘어져있다면 break;
            int cnt = 0;
            boolean[][] check = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 0 || check[i][j]) continue;
                    dfs(map, check, i, j, N, M);
                    cnt++;
                }
            }
            if(cnt>=2) break;
            if(cnt==0){
                year = 0;
                break;
            }

            year++;
            // 전체 map 탐색하며 빙하 녹이기
            int[][] newZeroCntMade = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) continue; // 물 부분이라 스킵
                    map[i][j] -= zeroCnt[i][j]; // 0의 개수만큼 빼기
                    if(map[i][j] <= 0){ // 빙하에서 물이 되었다.
                        map[i][j] = 0;
                        for(int k=0; k<dr.length; k++){
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                            newZeroCntMade[nr][nc]++;
                        }
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    zeroCnt[i][j] += newZeroCntMade[i][j];
                }
            }



        }

        System.out.println(year);
    }

    public static void dfs(int[][] map, boolean[][] check, int r, int c, int N, int M){
        // 기저 조건이 여기에선 딱히 없는듯

        // for문 돌리기
        for(int i=0; i<dr.length; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==0 || check[nr][nc] ) continue;
            check[nr][nc] = true;
            dfs(map, check, nr, nc, N, M);
        }

    }
}
