import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] memo = new long[N][2]; // i자리의 수에서 끝자리가 0과 1인 경우의 개수
        for(long[] arr : memo){
            Arrays.fill(arr, -1);
        }
        memo[0][0] = 0;
        memo[0][1] = 1; // 맨 처음엔 1로 시작되어야 하기 때문

        dp(memo, N-1);
        System.out.println(memo[N-1][0] + memo[N-1][1]);
    }

    private static void dp(long[][] memo, int i) {
        // 기저 조건
        if(i==0) return;
        if(memo[i][0] != -1 || memo[i][1] != -1) return;

        dp(memo, i-1);
        memo[i][0] = memo[i-1][0] + memo[i-1][1];
        memo[i][1] = memo[i-1][0];

    }
}
