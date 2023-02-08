import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];
            for(int i=0; i<2; i++){
                String[] words = br.readLine().split(" ");
                for(int j=0; j<n; j++){
                    stickers[i][j] = Integer.parseInt(words[j]);
                }
            }

            int[][] memo = new int[2][n];
            memo[0][0] = stickers[0][0];
            memo[1][0] = stickers[1][0];

            dp(stickers, memo, n-1);

            sb.append(Math.max(memo[0][n-1], memo[1][n-1])).append("\n");
        }
        System.out.println(sb);
    }

    private static void dp(int[][] stickers, int[][] memo, int n) {
        if(n==0) return;
        if(memo[0][n] != 0) return;

        dp(stickers, memo, n-1);
        memo[0][n] = memo[1][n-1] + stickers[0][n];
        memo[1][n] = memo[0][n-1] + stickers[1][n];

        // 앞에 것을 쓰는 경우도 있고 안 쓰는 경우도 있으니 그것도 계산을 해야 한다.
        if(n<2) return;
        int forward = memo[0][n-2] + stickers[1][n];
        int forward2 = memo[1][n-2] + stickers[0][n];

        memo[0][n] = Math.max(memo[0][n], forward2);
        memo[1][n] = Math.max(memo[1][n], forward);

    }
}
