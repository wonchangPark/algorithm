import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준
public class Q14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int H = Integer.parseInt(temp[0]);
        int W = Integer.parseInt(temp[1]);

        String[] temp2 = br.readLine().split(" ");
        int total = 0;
        int border = Integer.parseInt(temp2[0]);
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(temp2[0]));
        for(int i=1; i<W; i++){
            int block = Integer.parseInt(temp2[i]);

            int cnt = 0;
            while(true){
                if(!stack.isEmpty() && stack.peek() < block){
                    if(border < block){
                        total += border - stack.pop();
                    } else {
                        total += block - stack.pop();
                    }
                    cnt++;
                } else {
                    if(border < block){
                        while(!stack.isEmpty()){
                            stack.pop();
                        }
                        border = block;
                    } else {
                        for(int j=0; j<cnt; j++){
                            stack.push(block);
                        }
                    }
                    stack.push(block);
                    break;
                }
            }
        }

        System.out.println(total);
    }
}
