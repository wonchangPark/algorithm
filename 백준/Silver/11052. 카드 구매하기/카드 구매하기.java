import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        String[] temp = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(temp[i-1]);
        }

        int[] memo = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                memo[i] = Math.max(memo[i], memo[i-j] + arr[j]);
            }
        }

        System.out.println(memo[N]);
    }
}
