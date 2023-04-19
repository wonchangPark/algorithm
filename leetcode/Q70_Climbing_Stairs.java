import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q70_Climbing_Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(1);
            return;
        }

        // 1. bottom-top 방법
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        for(int i=3; i<=n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        System.out.println(memo[n]);

    }


    // 2. top-bottom 재귀이용한 방법
    public int dp(int n, int[] memo){
        if(memo[n] != 0){
            return memo[n];
        }

        memo[n] = dp(n-1, memo) + dp(n-2, memo);
        return memo[n];
    }
}
