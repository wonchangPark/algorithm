import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = br.readLine().split(" ");
        int a = Integer.parseInt(words[0]);
        int b = Integer.parseInt(words[1]);

        boolean[][] family = new boolean[n+1][n+1];
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            String[] words2 = br.readLine().split(" ");
            int x = Integer.parseInt(words2[0]);
            int y = Integer.parseInt(words2[1]);
            family[x][y] = true;
            family[y][x] = true;
        } // 가족 보드 완성
        dfs(family, new boolean[n+1], a, 0, n, b);
        if(ans == Integer.MIN_VALUE) ans = -1;
        System.out.println(ans);

    }

    public static void dfs(boolean[][] family, boolean[] visited, int now, int cnt, int n, int destination){
        if(now == destination){
            ans = cnt;
            return;
        }

        for(int i=1; i<=n; i++){
            if(family[now][i] && !visited[i]){
                visited[i] = true;
                dfs(family, visited,i, cnt+1, n, destination);
            }
        }
    }
}
