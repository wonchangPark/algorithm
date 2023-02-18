import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //나의 위치
        int k = Integer.parseInt(st.nextToken()); //동생의 위치
        // +1, -1, *2 총 3가지 방법으로 이동할 수 있다. 모든경우를 이동을 하면서 이미 이동한 경우에는 체크를 하고 그 자리까지 몇번에 이동할 수 있는지를
        // 체크하면서 목적지인 동생의 위치까지 이동한다.
        int[] whereYouAt = new int[100001]; // 몇번에 자리에 왔는지 카운트
        int[] parents = new int[100001];
        boolean[] check = new boolean[100001]; // 그 자리에 왔었었는지
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = true;
        parents[n] = -1;
        int ans = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(temp==k){
                ans = whereYouAt[temp];
                sb.append(ans+"\n");
                int parent = temp;
                while(true){
                    if(parents[parent]==-1){
                        stack.add(parent);
                        break;
                    }
                    stack.add(parent);
                    parent = parents[parent];
                }
                break;
            }
            if(temp-1>=0){
                if(!check[temp-1]){
                    whereYouAt[temp-1] = whereYouAt[temp] + 1;
                    check[temp-1] = true;
                    parents[temp-1] = temp;
                    queue.add(temp-1);
                }
            }
            if(temp+1<=100000){
                if(!check[temp+1]){
                    whereYouAt[temp+1] = whereYouAt[temp] + 1;
                    check[temp+1] = true;
                    parents[temp+1] = temp;
                    queue.add(temp+1);
                }
            }
            if(temp*2<=100000){
                if(!check[temp*2]){
                    whereYouAt[temp*2] = whereYouAt[temp] + 1;
                    check[temp*2] = true;
                    parents[temp*2] = temp;
                    queue.add(temp*2);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }
}