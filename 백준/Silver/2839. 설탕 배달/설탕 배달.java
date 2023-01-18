import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[5001];

        int ans = dp(N, cnt);
        System.out.println(ans);

    }

    public static int dp(int n, int[] cnt){
        cnt[1] = -1;
        cnt[2] = -1;
        cnt[3] = 1;
        cnt[4] = -1;
        cnt[5] = 1;
        for(int i=6; i<=n; i++){
            if(cnt[i-3]>0){
                cnt[i] = cnt[i-3] + 1;
            }
            if(cnt[i-5]>0){
                cnt[i] = cnt[i-5] + 1;
            }
            if(cnt[i] == 0){
                cnt[i] = -1;
            }
        }

        return cnt[n];

    }

}
