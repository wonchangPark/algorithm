import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 개수
        int P = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 개수
        boolean[][] network = new boolean[N+1][N+1];
        boolean[] check = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<P; i++){
            String[] temp = br.readLine().split(" ");
            int computerFrom = Integer.parseInt(temp[0]); // 몇 번째 컴퓨터
            int computerTo = Integer.parseInt(temp[1]); // 몇 번째 컴퓨터
            network[computerFrom][computerTo] = true;
            network[computerTo][computerFrom] = true; // 두 방향 모두 체크
        }

        queue.add(1); // 1번 컴퓨터
        check[1] = true;
        int ans = 0;
        while(!queue.isEmpty()){
            int now = queue.poll(); // 몇번 컴퓨터인지
            for(int i=1; i<N+1; i++){
                if(check[i]) continue; // check가 이미 되어있어서 방문한 곳이거나
                if(network[now][i]) {
                    check[i] = true;
                    ans++;
                    queue.add(i);
                }
            }
        }
        System.out.println(ans);
    }
}
