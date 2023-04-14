import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        Deque<Node> deque = new ArrayDeque<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value>num){
                deque.removeLast();
            }
            deque.offer(new Node(num, i));
            // L개만 가지고 비교하기 때문에 i-L보다 작아지는 수의 경우엔 비교대상이 아니므로 뺀다.
            if(deque.getFirst().idx <= i-L){
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value+" ");
        }

        bw.flush();
        bw.close();

    }
}
