import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+2]; // 걸리는 일수
        int[] P = new int[N+2]; // 금액

        for(int i=1; i<=N; i++){
            String[] temp = br.readLine().split(" ");
            T[i] = Integer.parseInt(temp[0]);
            P[i] = Integer.parseInt(temp[1]);

        }

        int[] memo = new int[N+2];
        int max = 0;
        for(int i=1; i<=N; i++){
            // 굳이 이중 for문을 돌면서 하나에 대해 다 추가하고 다시 와서 도는 식으로 할 필요가 없다.
            // 다음과 같이 그 다음 값에만 값을 비교하며 최대값을 유지한다. 이렇게 하면 O(N) 으로 가능하다.
            max = Math.max(max, memo[i]);
            memo[i] = max;
            if(i + T[i] <= N+1){ // 기존의 값과 새로운 값을 비교
                memo[i+T[i]] = Math.max(memo[i+T[i]], max + P[i]);
            }
        }

        int ans = Math.max(memo[N], memo[N+1]);
        System.out.println(ans);
    }
}
