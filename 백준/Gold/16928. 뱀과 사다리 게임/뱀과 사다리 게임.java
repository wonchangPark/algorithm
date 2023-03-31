import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제 16928. 뱀과 사다리 게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리
        int m = Integer.parseInt(st.nextToken()); // 뱀
        boolean[] check = new boolean[101];
        int[] cnt = new int[101];
        HashMap<Integer,Integer> ladderAndSnake = new HashMap<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            ladderAndSnake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            ladderAndSnake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] plusRange = {1,2,3,4,5,6};
        Queue<Integer> queue = new LinkedList<>();
        check[1] = true;
        cnt[1] = 0;
        queue.add(1);
        while(!queue.isEmpty()){
            int now = queue.poll();
            //System.out.println("지금 여기는 "+now+" : "+cnt[now]);
            if(now==100){
                break;
            }
            for(int i=0; i<6; i++){
                int temp = now + plusRange[i];
                if(1<=temp&&temp<101&&!check[temp]){
                    check[temp] = true;
                    cnt[temp] = cnt[now] + 1;
                    if(ladderAndSnake.containsKey(temp)){
                        int newTemp = ladderAndSnake.get(temp);
                        if(!check[newTemp]) {
                            check[newTemp] = true;
                            cnt[newTemp] = cnt[temp];
                            queue.add(newTemp);
                        }
                    }
                    else{
                        queue.add(temp);
                    }
                }
            }
        }
        System.out.println(cnt[100]);
    }
}
