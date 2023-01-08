import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        int N = Integer.parseInt(words[0]);
        int M = Integer.parseInt(words[1]);
        int V = Integer.parseInt(words[2]);
        int[][] board = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            board[from][to] = 1;
            board[to][from] = 1;
        }

        dfs(board, new boolean[N+1], V);
        sb.append("\n");
        bfs(board, N, V);
        System.out.println(sb);

    }

    public static void dfs(int[][] board, boolean[] visited, int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for(int i=1; i<visited.length; i++){
            if(!visited[i] && board[start][i]!=0) {
                dfs(board, visited, i);
            }
        }
    }

    public static void bfs(int[][] matrix,int N,  int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");

            for(int i=1; i<N+1; i++) {
                if(!visited[i] && matrix[v][i]!=0) {
                    queue.offer(i);
                    visited[i] =true;
                }
            }
        }
    }
}
