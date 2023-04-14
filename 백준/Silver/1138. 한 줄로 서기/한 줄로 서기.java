import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        List<Integer> list = new LinkedList<>();

        // 키가 큰 사람부터 시작하면서 앞에 몇명이 있는지를 체크하는 것이 더 쉽기 때문에 맨 뒤부터 시작한다.
        for(int i=line.length-1; i>=0; i--){
            int num = Integer.parseInt(line[i]);
            list.add(num, i+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
