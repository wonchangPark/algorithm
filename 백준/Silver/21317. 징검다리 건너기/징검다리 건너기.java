import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] memo = new int[N+1][2];
        int[][] energy = new int[N+1][2]; // 각 자리에서 점프시 필요한 에너지
        for(int i=1; i<=N-1; i++){
            String[] temp = br.readLine().split(" ");
            int jump = Integer.parseInt(temp[0]);
            int bigJump = Integer.parseInt(temp[1]);
            energy[i][0] = jump;
            energy[i][1] = bigJump;
        }


        if(N==1) {
            System.out.println(0);
            return;
        } else if(N==2){
            System.out.println(energy[1][0]);
            return;
        } else if(N==3){
            System.out.println(Math.min(energy[1][0] + energy[2][0], energy[1][1]));
            return;
        }

        int K = Integer.parseInt(br.readLine()); // k
        memo[2][0] = energy[1][0];
        memo[4][1] = K;



        int tempAns = dp(memo, energy, N);
        int tempAns2 = dpWithK(memo, energy, N, K);
        System.out.println(Math.min(tempAns, tempAns2));

    }

    private static int dpWithK(int[][] memo, int[][] energy, int n, int k) {
        if(memo[n][1]!=0){
            return memo[n][1];
        }
        if(n<=3) return 0;
        int temp1 = memo[n-3][0] + k;
        int temp2 = dpWithK(memo, energy, n-1, k) + energy[n-1][0];
        int temp3 = dpWithK(memo, energy, n-2, k) + energy[n-2][1];
        if(n-2==3) temp3 = temp2;
        int minValue = Math.min(temp1, temp2);
        minValue = Math.min(minValue, temp3);
        memo[n][1] = minValue;
        return minValue;
    }

    private static int dp(int[][] memo, int[][] energy, int n) {
        if(memo[n][0]!=0){
            return memo[n][0];
        }
        if(n<=2) return 0;
        int temp1 = dp(memo, energy, n-1)+energy[n-1][0];
        int temp2 = dp(memo, energy, n-2)+energy[n-2][1];
        int minValue = Math.min(temp1, temp2);
        memo[n][0] = minValue;
        return minValue;
    }
}
