import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1][N+1];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(palindrome(0, N-1, arr));


    }

    static int palindrome(int from, int to, int[] arr){
        if(from+1 == to && arr[from] != arr[to]) return 1;
        else if(from+1 == to && arr[from] == arr[to]) return 0;

        if(from >= to) return 0;
        if(memo[from][to] > 0) return memo[from][to];

        if(arr[from] == arr[to]){
            memo[from][to] = palindrome(from+1, to-1, arr);
            return memo[from][to];
        } else {
            // 양쪽이 다를때
            int temp1, temp2;
            temp1 = 1 + palindrome(from+1, to, arr);
            temp2 = 1 + palindrome(from, to-1, arr);
            if(temp1 < temp2){
                memo[from][to] = temp1;
            } else {
                memo[from][to] = temp2;
            }
            return memo[from][to];
        }
    }

}