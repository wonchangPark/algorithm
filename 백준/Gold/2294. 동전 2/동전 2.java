import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        int n = Integer.parseInt(words[0]);
        int k = Integer.parseInt(words[1]);
        int[] memo = new int[100001];
        int[] coins = new int[n];


        Arrays.fill(memo, Integer.MAX_VALUE - 1);
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            coins[i] = num;
        }

        memo[0] = 0;

        for(int i=0; i<n; i++){
            for(int j=coins[i]; j<=k; j++){
                memo[j] = Math.min(memo[j], memo[j-coins[i]] + 1);
            }
        }


        if(memo[k] == Integer.MAX_VALUE - 1) {
            System.out.println(-1);
        } else{
            System.out.println(memo[k]);
        }
    }

}
