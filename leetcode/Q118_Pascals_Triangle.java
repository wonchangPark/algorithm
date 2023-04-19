import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q118_Pascals_Triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> triangle = new ArrayList<>();
        int numRows = Integer.parseInt(br.readLine());
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int i=1; i<numRows; i++){
            List<Integer> prevList = triangle.get(i-1);
            List<Integer> nowList = new ArrayList<>();
            nowList.add(1);
            Stack<Integer> stack = new Stack<>();
            boolean flag = prevList.size() % 2 == 0;
            for(int j=1; j<=prevList.size()/2; j++){
                int num = prevList.get(j-1) + prevList.get(j);
                stack.push(num);
                nowList.add(num);
            }
            if(flag) stack.pop();
            while(!stack.isEmpty()){
                nowList.add(stack.pop());
            }
            nowList.add(1);
            triangle.add(nowList);
        }

        // triangle 완성

    }
}
