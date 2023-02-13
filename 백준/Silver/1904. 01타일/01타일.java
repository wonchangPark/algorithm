import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] memo = new int[1000000+1][2];
        memo[1][0] = 0;
        memo[1][1] = 1;
        memo[2][0] = 1;
        memo[2][1] = 1;


        dp(memo, N);

        System.out.println((memo[N][0] + memo[N][1])%15746);

    }

    private static void dp(int[][] memo, int n) {
        // 기저 조건
        if(n<=2) return;
        if(memo[n][0] != 0) return;

        //
        dp(memo, n-1);
        memo[n][1] = (memo[n-1][1] + memo[n-1][0]) % 15746;
        memo[n][0] = (memo[n-2][1] + memo[n-2][0]) % 15746;

    }
}