import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N+1];
        for(int i=1; i<=N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        } // 동전 값 완성

        int[] memo = new int[K+1];
        memo[0] = 1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j >= coins[i]) {
                    memo[j]+=memo[j-coins[i]];
                }
            }
        }

        System.out.println(memo[K]);

    }
}
