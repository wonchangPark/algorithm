import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7_Reverse_Integer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int ans = 0;
        while(x != 0){
            int pop = x % 10;
            x/=10;
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                ans = 0;
                break;
            }

            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                ans = 0;
                break;
            }
            ans = ans * 10 + pop;
        }

        System.out.println(ans);
    }
}
