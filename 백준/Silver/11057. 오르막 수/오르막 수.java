import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] memo = new int[N+1][10];
        for(int i=0; i<10; i++){
            memo[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    memo[i][j] += memo[i-1][k];
                    memo[i][j] %= 10007;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<10; i++){
            ans += memo[N][i];
            ans %= 10007;
        }
        System.out.println(ans);

    }

}
