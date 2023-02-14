import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] memo = new int[100001];
//
//        int N = Integer.parseInt(br.readLine());
//        int ans = dp(memo, N);
//        System.out.println(ans);
//    }
//
//    private static int dp(int[] memo, int n) {
//        if(memo[n] != 0) return memo[n];
//
//        memo[n] = n;
//        for(int i=1; i*i<=n; i++){
//            int temp = dp(memo, n-i*i) + 1;
//            if(memo[n] > temp) memo[n] = temp;
//        }
//        return memo[n];
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1]; // 하나의 수 n 을 제곱수들의 합으로 구현할 때, 제곱수들의 최소개수
        for(int i=1; i<=n; i++){
            d[i] = i;
            for(int j=1; j*j<=i; j++){
                int temp = d[i-j*j] + 1;
                if(d[i] > temp) d[i] = temp;
            }
        }
        // d[0]=0 이므로 i == j*j 일 시에는 자연스레 d[0]으로 오게 되며 그것에 +1을 해주므로 무조건 1이 된다.
        System.out.println(d[n]);
    }
}
