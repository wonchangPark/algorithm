import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String line = br.readLine();
            if(line == null) break;
            boolean isSub = false;
            StringTokenizer st = new StringTokenizer(line);
            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();

            int idx = 0;
            for(int i=0; i<t.length; i++){
                if(s[idx] == t[i]){
                    idx++;
                }
                if(idx == s.length){
                    isSub = true;
                    break;
                }
            }
            if(isSub){
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }

        }
        System.out.println(sb);
    }
}
