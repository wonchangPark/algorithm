import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[1001];
        memo[1] = 1;
        memo[2] = 3;
        int ans = dp(memo, n);
        System.out.println(ans);
    }

    private static int dp(int[] memo, int n) {
        if(n<=2) return memo[n];
        if(memo[n] > 0) return memo[n];

        memo[n] = (dp(memo, n-1) + dp(memo, n-2) * 2) % 10007;
        return memo[n];
    }
}
