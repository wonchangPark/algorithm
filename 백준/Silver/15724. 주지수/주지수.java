import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        int[][] sum = new int[N+1][M+1]; // 누적합
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = arr[i][j] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startColumn = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endColumn = Integer.parseInt(st.nextToken());

            int ans = sum[endRow][endColumn] - sum[endRow][startColumn-1] - sum[startRow-1][endColumn] + sum[startRow-1][startColumn-1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

}
