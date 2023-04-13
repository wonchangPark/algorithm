import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        int[][] board = new int[N][M];
        for(int i=0; i<N; i++){
            String[] temp2 = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(temp2[j]);
            }
        }

        int ans = N*M*2; // 겉넓이
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int num = board[i][j];
                for(int k=1; k<=num; k++){
                    ans += check(i, j, k, board, N, M);
                }
            }
        }



        System.out.println(ans);
    }

    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    private static int check(int r, int c, int h, int[][] board, int n, int m) {
        int sum = 0;
        // 6방향으로 체크한다.
        // 범위가 벗어나면 sum++ 해준다.
        for(int i=0; i<6; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0 || nr>=n || nc<0 || nc>=m){
                sum++;
                continue;
            }

            if(h > board[nr][nc]){
                sum++;
            }

        }


        return sum;
    }


}
