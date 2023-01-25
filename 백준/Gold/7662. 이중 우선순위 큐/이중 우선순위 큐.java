import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());
            for(int i=0; i<k; i++){
                String[] words = br.readLine().split(" ");
                String order = words[0];
                int value = Integer.parseInt(words[1]);
                if(order.equals("I")){
                    insert(value, map);
                } else delete(map, value == 1);
            }

            if(map.isEmpty()) {
                sb.append("EMPTY");
            } else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }
            sb.append("\n");

        }

        System.out.println(sb);

    }

    private static void insert(int key, TreeMap<Integer, Integer> map) {
        if(map.containsKey(key)){
            int cnt = map.get(key);
            map.replace(key, cnt+1);
        } else {
            map.put(key, 1);
        }
    }

    private static void delete(TreeMap<Integer, Integer> map, boolean flag) {
        if(map.isEmpty()) return;
        if(flag){ // 최댓값을 빼야함
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            int key = entry.getKey();
            int value = entry.getValue();
            if(value-1>0){ // 중복된 수들이 더 있음
                map.replace(key, value-1);
            } else {
                map.pollLastEntry();
            }
        } else{
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            int key = entry.getKey();
            int value = entry.getValue();
            if(value-1>0){ // 중복된 수들이 더 있음
                map.replace(key, value-1);
            } else {
                map.pollFirstEntry();
            }
        }

    }
}
