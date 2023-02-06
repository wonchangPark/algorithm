import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N+1][3];
        for(int i=1; i<=N; i++){
            String[] temp = br.readLine().split(" ");
            rgb[i][0] = Integer.parseInt(temp[0]);
            rgb[i][1] = Integer.parseInt(temp[1]);
            rgb[i][2] = Integer.parseInt(temp[2]);
        }

        int[][] ans = new int[N+1][3]; // memoization
        ans[1][0] = rgb[1][0];
        ans[1][1] = rgb[1][1];
        ans[1][2] = rgb[1][2];

        dp(rgb, ans, N);

        System.out.println(Math.min(Math.min(ans[N][0], ans[N][1]), ans[N][2]));
    }

    private static void dp(int[][] rgb, int[][] ans, int n) {
        if(n==1) return;
        if(ans[n][0] != 0) return;

        dp(rgb, ans, n-1);
        ans[n][0] = Math.min(ans[n-1][1], ans[n-1][2]) + rgb[n][0];
        ans[n][1] = Math.min(ans[n-1][0], ans[n-1][2]) + rgb[n][1];
        ans[n][2] = Math.min(ans[n-1][1], ans[n-1][0]) + rgb[n][2];
    }
}
