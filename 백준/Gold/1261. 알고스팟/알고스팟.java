import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<int[]> deque = new LinkedList<>();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        int[][] cntBoard = new int[n][m];
        for(int i=0; i<n; i++){
            char[] words = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                board[i][j] = words[j];
            }
        }
        // 0,0 에서 n-1,m-1 까지 가는 것
        cntBoard[0][0] = 1;
        deque.addFirst(new int[]{0,0});
        int cnt = 1;
        while(!deque.isEmpty()){
            int[] whereYouAt = deque.poll();
            int newN = whereYouAt[0];
            int newM = whereYouAt[1];
            if(board[newN][newM]=='1'){
                cnt=cntBoard[newN][newM];
            }
            for (int i = 0; i < 4; i++) {
                int tempN = newN + dx[i];
                int tempM = newM + dy[i];
                if (0 <= tempN && tempN < n && 0 <= tempM && tempM < m) {
                    if(cntBoard[tempN][tempM]==0) {
                        if (board[tempN][tempM] == '1') {
                            cntBoard[tempN][tempM] = cnt + 1;
                            deque.addLast(new int[]{tempN, tempM});
                        } else {
                            cntBoard[tempN][tempM] = cnt;
                            deque.addFirst(new int[]{tempN, tempM});
                        }
                    }
                }
            }
        }

        System.out.println(cntBoard[n-1][m-1]-1); // 0이 아닌 1부터 카운트를 했기 때문에 1을 빼준다. 원래대로 돌려놓는 것일뿐

    }
}