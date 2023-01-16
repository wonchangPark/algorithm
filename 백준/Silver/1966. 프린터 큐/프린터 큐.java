import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String[] words = br.readLine().split(" ");
            int N = Integer.parseInt(words[0]); // 문서의 개수
            int M = Integer.parseInt(words[1]); // 문서가 현재 Queue에서 몇 번째에 놓여 있는지 나타내는 정수
            String[] tempImportance = br.readLine().split(" ");
            int[] impCnt = new int[10];
            Queue<Integer> queue = new LinkedList<>();

            for (String s : tempImportance) {
                int importance = Integer.parseInt(s);
                impCnt[importance]++;
                queue.add(importance);
            }

            // 나중에 문서들이 자신의 중요도보다 큰 수가 있는지 확인하기 위해
            Stack<Integer> stack = new Stack<>(); // 1~9까지의 중요도에서 실제로 있는 중요도의 경우 스택에 작은 숫자 먼저 넣는다.
            for(int j=1; j< impCnt.length; j++){
                if(impCnt[j]==0) continue;
                stack.push(j);
            }

            // 중요도를 넣어놓은 스택과 중요도 개수 배열이 있으면 편할 것 같다.
            int nowM = M;
            int ans = 0;
            while(true){
                int nowImportance = queue.poll();
                nowM--;
                if(nowImportance<stack.peek()){
                    // 중요도가 지금 문서의 것보다 높은 것이 있으므로 큐에 다시 넣는다.
                    queue.add(nowImportance);

                    // 만약 M 번째 문서였다면 nowM을 다시 맞춰준다.
                    if(nowM == -1){
                        nowM = queue.size() - 1; // queue의 맨 뒤로 보내주기
                    }
                } else {
                    ans++;
                    // 큐에서 이 문서를 아예 빼버린다.
                    // 그리고 만약 이 중요도의 개수가 더이상 없다면 스택에서 이 중요도도 빼버린다.
                    if(--impCnt[nowImportance]==0){
                        stack.pop();
                    }

                    // 지금 빼는 문서가 M번째 문서라면 break
                    if(nowM == -1) {
                        break;
                    }
                }

            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
