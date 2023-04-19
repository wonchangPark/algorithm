import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] memo = new int[10001][4];
        memo[1][1] = 1;
        memo[2][1] = 1;
        memo[2][2] = 1;
        memo[3][1] = 1;
        memo[3][2] = 1;
        memo[3][3] = 1;


        for(int i=4; i<=10000; i++){
            memo[i][1] = memo[i-1][1];
            memo[i][2] = memo[i-2][1] + memo[i-2][2];
            memo[i][3] = memo[i-3][1] + memo[i-3][2] + memo[i-3][3];
        }
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int ans = memo[n][1] + memo[n][2] + memo[n][3];
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}
